/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author student
 */
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
      System.out.println(dict.size());
    }
    
    public void findMatch(WordMatcher matcher){
        for (String word : dict){
            if (matcher.matchWord(word)) {
                System.out.println(word);
            }            
        }
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
    
    public int computeBestMatchForOne(String letters, int row, int column, boolean horizontal, int lastBest){
        WordMatcher match = new WordMatcher();
        match.buildLetters(letters, Character.toString((char)scoreBoard[row][column]));
        String bestWord = null;
        int bestRow = 0;
        int bestColumn = 0;
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
            if (!isValid(word, row1, column1))
                continue;
            int score = computeScore(word, row1, column1, horizontal, new ScoreCalculator());            
            if (score > lastBest){
                bestWord = word;
                bestRow = row1;
                bestColumn = column1;
                lastBest = score;
                System.out.println(bestWord + " " + score + " row: " + row1 + " column: " + column1);                
            }
        }
        return lastBest;
    }
    
    private boolean isValid(String word, int row, int column){
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


