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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
    
    public void findMatch(String letters){ //get best position, best score for first time
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
                    if (j==0 || scoreBoard[i][j-1] == 0){                        
                         //check extend words---
                        result = computeBestMatchForOne(letters, i, j, true, result);                        
                    }
                    if (i==0 || scoreBoard[i-1][j] == 0){
                        result = computeBestMatchForOne(letters, i, j, false, result);   
                    }
                }
            }
        }
        return result;
    }
    
    public int computeScore(String word, int row, int column, boolean horizontal, ScoreCalculator calculator){
        StringBuilder builder = new StringBuilder();
        int multiplier = 1;
        if (horizontal) {
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
        else {
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
        System.out.println(word+"-"+builder + " Multiplier is " + multiplier+" at "+row+" "+column);
        
        return calculator.calculate(word+builder, multiplier);
    }
    
    public BestResult computeBestMatchForOne(String letters, int row, int column, boolean horizontal, BestResult result){
        int score1 = 0;
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
            score1 = isValid(word, row1, column1, horizontal);
            if (score1 == -1)
                continue;
     //       System.out.println(word+" r "+row1+" c "+column1+" "+horizontal);
            int score = computeScore(word, row1, column1, horizontal, new ScoreCalculator()) + score1;            
            if (score > result.score){
                result.word = word;
                result.row = row1;
                result.column = column1;
                result.score = score;
                result.horizontal = horizontal;
                System.out.println(result.word + " " + result.score + " row: " + row1 + " column: " + column1 + horizontal);                
            }
        }
        return result;
    }
    
    int findTopStart(int row, int col)
    {
        if (row==0)    //at the top edge
            return 0;
        for (int i = row-1; i>=0; i--){ //word hasn't been put on board, so row-1
            if (scoreBoard[i][col]==0){
                return i+1;
            }
        }
        return 0;
    }
    
    public List<BestResult> checkVerticalWord(String word, int row, int col){
        List<BestResult> results = new ArrayList<>();
        for (int j = col; j < word.length()+col; j++){
            if (scoreBoard[row][j] > 0){   //if the letter already exists there - bc new word hasn't been put on board
                continue;
            }
            int newi = findTopStart(row, j); 
            System.out.println("find vertical word for "+word+" " +row+" "+col+" start "+newi);           
            StringBuilder builder = new StringBuilder();
            for (int k=newi; k<boardSize; k++){
                if (k == row){ //if the row is on your own word
                    builder.append(word.charAt(j-col)); //put your letter in
                }
                else if (scoreBoard[k][j]>0){
                    builder.append(scoreBoard[k][j]);
                }
                else {
                    break;
                }
            }
            if (builder.length()>1){
                BestResult result = new BestResult();
                result.word = builder.toString();
                result.row = newi;
                result.column = j;
                result.horizontal = false;
                results.add(result);
                System.out.println("find vertical word "+result.word+" r "+newi+" c "+j);
            }
        }
        return results;
    }
    
    int findLeftStart(int row, int col)
    {
        if (col == 0)
            return 0;
        for (int i = col-1; i>=0; i--){  // find left most space
            if (scoreBoard[row][i]==0){
                return i+1;
            }
        }
        return 0;
    }
    
    public List<BestResult> checkHorizontalWord(String word, int row, int col){
        List<BestResult> results = new ArrayList<>();
        //System.out.println("find horizontal word for "+word);
        for (int r = row; r < word.length()+row; r++){
            if (scoreBoard[r][col] > 0){   //if the letter already exists there - bc new word hasn't been put on board
                continue;
            }
            int iStart = findLeftStart(r, col);
            System.out.println("find horizontal word for "+word+" start "+iStart);
            StringBuilder builder = new StringBuilder();
            for (int k=iStart; k<boardSize; k++){ //add letter from left most blank space
                if (k == col){ //if the row is on your own word
                    builder.append(word.charAt(r-row)); //put your letter in
                }
                else if (scoreBoard[r][k]>0){
                    builder.append(scoreBoard[r][k]);
                }
                else {
                    break;
                }
            }
            if (builder.length()>1){
                BestResult result = new BestResult();
                result.word = builder.toString();
                result.column = iStart;
                result.row = r;
                result.horizontal = true;
                results.add(result);
                System.out.println("find horizontal word "+result.word+" r "+r+" c "+iStart);
            }
        }
        return results;
    }

    
    public int isValid(String word, int row, int column, boolean horizontal){
        ScoreCalculator calculator1 = new ScoreCalculator();
        if (row < 0 || column < 0) {
            return -1; //-1 means invalid
        }
        if (horizontal){
            //System.out.println("horizontal, " + word + column);
            if (column+word.length()>boardSize){
                return -1;
            }
            
            for (int j = column; j < word.length()+column; j++){
                if (scoreBoard[row][j] > 0){
                    if (word.charAt(j-column) != scoreBoard[row][j]){
                        return -1;
                    }
                }    
            }
            //System.out.println("word within horizontal boundary + no overlap");
            if (column > 0 && scoreBoard[row][column-1] != 0){
                return -1;
            }
            if (column+word.length() < boardSize && scoreBoard[row][word.length()+column] != 0){
                return -1;
            }
        }
        else {
            if (row+word.length()>boardSize){ //boundary
                return -1;
            }
            for (int i = row; i < word.length()+row; i++){ //no overlap
                if (scoreBoard[i][column] > 0){
                    if (word.charAt(i-row) != scoreBoard[i][column]){
                        return -1;
                    }
                }
            }
            //System.out.println("word within vertical boundary + no overlap");
            if (row > 0 && scoreBoard[row-1][column] != 0){
                return -1;
            }
            // exceed bottom bound, or it connects to another word
            if (row+word.length() < boardSize && scoreBoard[row+word.length()][column] != 0){
                return -1;
            }
        }
        List<BestResult> results;
        if (horizontal)
            results = checkVerticalWord(word, row, column); //loop through list, check every word to see if valid        
        else
            results = checkHorizontalWord(word, row, column); //same
        int score = 0;
        for (BestResult result : results) {
            if (!dict.contains(result.word)){
                return -1;
            } //-1 means invalid, 0 above means score of extra words
            score = computeScore(result.word, result.row, result.column, horizontal, calculator1);
            System.out.println("score "+score + " "+result.word + " "+result.horizontal);
        }
        return score;
    }
    public boolean isAboveEmpty(int row, int col){
        int i = row-1;
        if (i<0){
            return false;
        }
        return (scoreBoard[i][col]==0);               
    }
    
    public boolean isBelowEmpty(int row, int col){
        int i = row+1;
        if (i>boardSize){
            return false;
        }
        return (scoreBoard[i][col]==0);
    }
    
    public boolean isLeftEmpty(int row, int col){
        int j = col-1;
        if (j<0){
            return false;
        }
        return (scoreBoard[row][j]==0);
    }
    
    public boolean isRightEmpty(int row, int col){
        int j = col+1;
        if (j>boardSize){
            return false;
        }
        return (scoreBoard[row][j]==0);
    }
    
    public void enterWord(String word, int row, int column, boolean horizontal, int score,boolean write){
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
        if (!write)
            return;
        try(FileWriter fw = new FileWriter("output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(row+","+column+","+word+","+""+horizontal + ", " + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
    public boolean checkWord(String word) {
        if (dict.contains(word)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public void reloadGame() {
        try {
            FileInputStream fis = new FileInputStream("output.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                String[] parts = line.split(",");
                String rowString = parts[0];
                String columnString = parts[1];
                String word = parts[2];
                String horizontalString = parts[3];
                int row = Integer.parseInt(rowString);
                int column = Integer.parseInt(columnString);
                boolean horizontal = Boolean.parseBoolean(horizontalString);
                enterWord(word,row,column,horizontal,0,false);
                line = reader.readLine();
            }           
           
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


