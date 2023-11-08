package model;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private final List<Integer> winningDetails = new ArrayList<>();

    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    private final int MATCH_THREE = 3;
    private final int MATCH_FOUR = 4;
    private final int MATCH_FIVE = 5;
    private final int MATCH_FIVE_BONUS = 7;
    private final int MATCH_SIX = 6;

    private enum Match {

        THREE("3개 일치 (5,000원) - "),
        FOUR("4개 일치 (50,000원) - "),
        FIVE("5개 일치 (1,500,000원) - "),
        FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX("6개 일치 (2,000,000,000원) - ");

        private final String message;
        Match(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }

    }
    private final String COUNT_MESSAGE = "개";
    public void addRank(int rank){
        winningDetails.add(rank);
    }

    public List<Integer> getWinningDetails() {

        return winningDetails;
    }

    public void printResult(){

        System.out.println(Match.THREE.getMessage()+fifth+COUNT_MESSAGE);
        System.out.println(Match.FOUR.getMessage()+fourth+COUNT_MESSAGE);
        System.out.println(Match.FIVE.getMessage()+third+COUNT_MESSAGE);
        System.out.println(Match.FIVE_BONUS.getMessage()+second+COUNT_MESSAGE);
        System.out.println(Match.SIX.getMessage()+first+COUNT_MESSAGE);
    }
    public void calculateResult(){
        for(int win : winningDetails){
            matchRank(win);
        }
    }

    private void matchRank(int win){
        switch (win) {
            case MATCH_THREE -> fifth++;
            case MATCH_FOUR -> fourth++;
            case MATCH_FIVE -> third++;
            case MATCH_SIX -> first++;
            case MATCH_FIVE_BONUS -> second++;
        }
    }
}
