/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 *
 * @author student
 */
class BestResult {
    public String word = null;
    public int row = 0;
    public int column = 0;
    public int score = 0;
    public boolean horizontal = true;
}

public class ScrabbleEngine {
    private Set<String> dict = new HashSet<String>(); 
    final int boardSize = 15;
    char [][]scoreBoard = new char[boardSize][boardSize];
    int [][]scoreMod = new int[boardSize][boardSize];
   
    
    public ScrabbleEngine(){
        int mid = boardSize/2;
        for (int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                scoreMod[i][j] = 1;
                
                if (i == 0 || i == 14){
                    if (j % mid == 0){
                        scoreMod[i][j] = 30;
                    }
                    else if (j == 3 || j == boardSize-4){
                        scoreMod[i][j] = 2;
                    }                     
                }
                
                else {
                    if ((i == j || i == boardSize-j-1) && i != 5 && i != 6 && i != 8 && i != 9)
                        scoreMod[i][j] = 20;
                    else if ((i-1)%4 == 0 && (j-1)%4 == 0)
                        scoreMod[i][j] = 3;
                    else if (i == mid && (j == 0 || j == boardSize-1))
                        scoreMod[i][j] = 30;
                    else if ((i == 2 || i == boardSize-3)){
                        scoreMod[i][mid+1] = 2;
                        scoreMod[i][mid-1] = 2;
                    }
                    else if ((i == 3 || i == boardSize-4)){
                        if (j%mid == 0){
                            scoreMod[i][j] = 2;
                        }
                    }
                    else if (i == mid && (j == 3 || j == boardSize-4)){
                        scoreMod[i][j] = 2; 
                    }
                    else if (i == mid-1 || i == mid+1) {
                        scoreMod[i][2] = 2;
                        scoreMod[i][boardSize-3] = 2;
                        scoreMod[i][mid+1] = 2;
                        scoreMod[i][mid-1] = 2;                                             
                    }                    
                }                
            }
        }
        for (int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                System.out.print(scoreMod[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void initDictionary(String fileName){
        String thisLine = null;
      try{
         // open input stream test.txt for reading purpose.
         BufferedReader br = new BufferedReader(new FileReader(fileName));
         while ((thisLine = br.readLine()) != null) {
            dict.add(thisLine);
         }       
      }
      catch(Exception e){
         e.printStackTrace();
      }
      System.out.println("dictionary size: " + dict.size());
    }
    
    public void findMatch(String letters){ //get best position, best score
        WordMatcher matcher = new WordMatcher();
        matcher.buildLetters(letters);
        int bestScore = 0;
        String bestWord = null;
        for (String word : dict){
            if (matcher.matchWord(word)) {
                int score = computeScore(word, 7, 7, true, new ScoreCalculator());
                if (score > bestScore) {
                    bestWord = word;
                    bestScore = score;
                    System.out.println(bestWord + bestScore);
                }    
            }
        }
        System.out.println(bestWord + bestScore);
    }
    
    public BestResult findBestMatch(String letters){
        BestResult result = new BestResult();        
        for (int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                if (scoreBoard[i][j] > 0){
                    if (j>0){                        
                        if (scoreBoard[i][j-1] == 0){
                            result = computeBestMatchForOne(letters, i, j, true, result);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public int computeScore(String word, int row, int column, boolean horizontal, ScoreCalculator calculator){
        StringBuilder builder = new StringBuilder();
        int multiplier = 1;
        if (horizontal == true) {
        for (int j = column; j<word.length()+column; j++){
            if (scoreBoard[row][j] > 0)
                continue;            
            if (scoreMod[row][j] == 2){
                builder.append(word.charAt(j-column));
            }
            else if (scoreMod[row][j] == 3){
                builder.append(word.charAt(j-column));
                builder.append(word.charAt(j-column));
            }
            else if (scoreMod[row][j] >= 20){
                multiplier *= scoreMod[row][j]/10;
            }        
        }
        }
        else if (horizontal == false){
            for (int i = row; i<word.length()+row; i++){
            if (scoreBoard[i][column] > 0)
                continue;   
            if (scoreMod[i][column] == 2){
                builder.append(word.charAt(i-row));
            }
            else if (scoreMod[i][column] == 3){
                builder.append(word.charAt(i-row));
                builder.append(word.charAt(i-row));
            }
            else if (scoreMod[i][column] >= 20){
                multiplier *= scoreMod[i][column]/10;
            }        
            }
        }
    //    System.out.println(builder + " Multiplier is " + multiplier);
        return calculator.calculate(word+builder, multiplier);
    }
    
    public BestResult computeBestMatchForOne(String letters, int row, int column, boolean horizontal, BestResult result){
        WordMatcher match = new WordMatcher();
        match.buildLetters(letters, Character.toString((char)scoreBoard[row][column]));
        for (String word : dict){
            if (!match.matchWord(word)) {
                continue;
            }
            int index = word.indexOf(scoreBoard[row][column]); //test fantastic-second index for a 
            int column1 = column;
            int row1 = row;
            if (horizontal)
                column1 -= index;
            else 
                row1 -= index;
            if (!isValid(word, row1, column1, horizontal))
                continue;
            int score = computeScore(word, row1, column1, horizontal, new ScoreCalculator());            
            if (score > result.score){
                result.word = word;
                result.row = row1;
                result.column = column1;
                result.score = score;
                result.horizontal = horizontal;
                System.out.println(result.word + " " + result.score + " row: " + row1 + " column: " + column1);                
            }
        }
        return result;
    }
    
    public List<BestResult> checkVerticalWord(String word, int row, int col){
        List<BestResult> results = new ArrayList<>();
        return results;
    }
    
    public List<BestResult> checkHorizontalWord(String word, int row, int col){
        return new ArrayList<>();
    }

    
    public boolean isValid(String word, int row, int column, boolean horizontal){
        if (row < 0 || column < 0) {
            return false;
        }
        if (horizontal = true){
            if (column+word.length()>boardSize){
                return false;
            }
            for (int j = column; j < word.length()+column; j++){
                if (scoreBoard[row][j] > 0){
                    if (word.charAt(j-column) != scoreBoard[row][j]){
                        return false;
                    }
                }    
            }
            if (column > 0 && scoreBoard[row][column-1] != 0){
                return false;
            }
            if (column+word.length() < boardSize && scoreBoard[row][word.length()+column] != 0){
                return false;
            }
        }
        if (horizontal = false){
            if (row+word.length()>boardSize){
                return false;
            }
            for (int i = row; i < word.length()+row; i++){
                if (scoreBoard[i][column] > 0){
                    if (word.charAt(i-row) != scoreBoard[i][column]){
                        return false;
                    }
                }
            }
            if (row > 0 && scoreBoard[row-1][column] != 0){
                return false;
            }
            if (row+word.length() < boardSize && scoreBoard[row+word.length()][column] != 0){
                return false;
            }
        }
        List<BestResult> results;
        if (horizontal = true)
            results = checkVerticalWord(word, row, column); //loop through list, check every word to see if valid        
        else
            results = checkHorizontalWord(word, row, column); //same
        for (BestResult result : results) {
            if (!dict.contains(result.word)){
                return false;
            }
        }
        
        return true;
    }
    
    public void enterWord(String word, int row, int column, boolean horizontal){
        if (horizontal == true) {
            for (int j = column; j<word.length()+column; j++){
                scoreBoard[row][j] = word.charAt(j-column);
            }
        }
        
        else if (horizontal == false) {
            for (int i = row; i<word.length()+row; i++){
                scoreBoard[i][column] = word.charAt(i-row);
            }
        }        
        System.out.println(printBoard());
    }
    
    public String printBoard(){
        StringBuilder build = new StringBuilder();
        for (int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                if (scoreBoard[i][j] > 0)
                    build.append(scoreBoard[i][j]);
                else {
                    build.append("*");
                }
            }
            build.append("\r\n"); //windows formatting new line
            
        }
        return build.toString();
    }
    
    
    
}


