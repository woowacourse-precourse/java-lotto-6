package lotto.domain;

import lotto.view.ExceptionMessage;
import lotto.view.view;

import static lotto.view.view.printNumberOfWinsMessage;

public enum numberOfWins {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    numberOfWins(int numberOfMatch, int prize, String message){
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
        this.message = message;
    }

    private static final int WINNING_MIN_NUMBER = 3;

    private int numberOfMatch;
    private int prize;
    private String message;


    public static numberOfWins valueOf(int numberOfMatch, boolean matchBonus){
        if(numberOfMatch < WINNING_MIN_NUMBER){
            return MISS;
        }

        if(SECOND.matchCount(numberOfMatch) && matchBonus){
            return SECOND;
        }

        for(numberOfWins number : values()){
            if(number.matchCount(numberOfMatch) && number != SECOND){
                return number;
            }
        }
        ExceptionMessage.errorMessage();
        throw new IllegalArgumentException();
    }

    private boolean matchCount(int countOfMatch){
        return this.numberOfMatch == countOfMatch;
    }

    public int getNumberOfMatch(){
        return numberOfMatch;
    }

    public int getPrize(){
        return prize;
    }

    public void printMessage(int count){
        if(this != MISS){
            printNumberOfWinsMessage(message, count);
        }
    }


}
