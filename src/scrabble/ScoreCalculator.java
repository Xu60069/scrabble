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
public class ScoreCalculator {
    
    public ScoreCalculator() {
        score1 = 0;
    }
    public int calculate(String word, int multiple) {
        final int[] scrabbleENScore={1,3,3,2,1,4,2,4,1,8,5,1,3,1,3,3,10,1,1,1,1,4,4,8,4,10};
        int score = 0;
        for (int i = 0; i < word.length(); i++){
            score += scrabbleENScore[word.charAt(i)-'a'];
        }
        score1 += score*multiple;
        return score1;
    }
    
    private int score1;
    
}
