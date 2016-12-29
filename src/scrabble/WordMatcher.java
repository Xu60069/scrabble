/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble;

/**
 *
 * @author student
 */
public class WordMatcher {
    //the number of the letters of alphabet u have
    private int[] letterCount = new int[26];
    private int[] matchCount = new int[26]; //stores the count of the letters in the word
    private String connectLetter = "";
    
    public void buildLetters(String myLetters){
        for (int i = 0; i<letterCount.length; i++){  //initialize 
            letterCount[i] = 0;
        }
        for (int i = 0; i<myLetters.length(); i++){ //put your letters into count
            letterCount[myLetters.charAt(i)-'a']++;
        }
    }
    
    public boolean matchWord(String word){
        if (!word.contains(connectLetter)){
            return false;
        }
        
        for (int i = 0; i<matchCount.length; i++){ //clear
            matchCount[i] = 0;
        }
                        
        for (int i = 0; i<word.length(); i++){ //put letters of word into count
            matchCount[word.charAt(i)-'a']++;
            if (matchCount[word.charAt(i)-'a'] > letterCount[word.charAt(i)-'a']) {
                return false;
            }
        }
        
        return true;
        
    }
    
    public void buildLetters(String myLetters, String matchLetter){
        buildLetters(myLetters);
        for (int i = 0; i<matchLetter.length(); i++){ //put your letters into count
            letterCount[matchLetter.charAt(i)-'a']++;
        }
        connectLetter = matchLetter;
    }
}
