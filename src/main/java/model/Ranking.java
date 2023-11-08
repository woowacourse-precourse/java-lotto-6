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
    private final String COUNT_MESSAGE = "개";



    public void addRank(int rank) {
        winningDetails.add(rank);
    }

    public List<Integer> getWinningDetails() {

        return winningDetails;
    }

    public void printResult() {

        System.out.println(Match.THREE.getMessage() + fifth + COUNT_MESSAGE);
        System.out.println(Match.FOUR.getMessage() + fourth + COUNT_MESSAGE);
        System.out.println(Match.FIVE.getMessage() + third + COUNT_MESSAGE);
        System.out.println(Match.FIVE_BONUS.getMessage() + second + COUNT_MESSAGE);
        System.out.println(Match.SIX.getMessage() + first + COUNT_MESSAGE);
    }

    public void calculateResult() {
        for (int win : winningDetails) {
            matchRank(win);
        }
    }

    private void matchRank(int win) {
        switch (win) {
            case MATCH_THREE -> fifth++;
            case MATCH_FOUR -> fourth++;
            case MATCH_FIVE -> third++;
            case MATCH_SIX -> first++;
            case MATCH_FIVE_BONUS -> second++;
        }
    }
}
