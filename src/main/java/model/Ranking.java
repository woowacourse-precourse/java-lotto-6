package model;

import java.util.ArrayList;
import java.util.List;

import static model.Match.*;

public class Ranking {
    private final List<Integer> winningDetails = new ArrayList<>();

    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    private final int WIN_THREE = 3;
    private final int WIN_FOUR = 4;
    private final int WIN_FIVE = 5;
    private final int WIN_FIVE_BONUS = 7;
    private final int WIN_SIX = 6;
    private final String COUNT_MESSAGE = "개";


    public void addRank(int rank) {
        winningDetails.add(rank);
    }

    public List<Integer> getWinningDetails() {

        return winningDetails;
    }

    public void printResult() {

        System.out.println(MATCH_THREE.getMessage() + fifth + COUNT_MESSAGE);
        System.out.println(MATCH_FOUR.getMessage() + fourth + COUNT_MESSAGE);
        System.out.println(MATCH_FIVE.getMessage() + third + COUNT_MESSAGE);
        System.out.println(MATCH_FIVE_BONUS.getMessage() + second + COUNT_MESSAGE);
        System.out.println(MATCH_SIX.getMessage() + first + COUNT_MESSAGE);
    }

    public void calculateResult() {
        for (int win : winningDetails) {
            matchRank(win);
        }
    }

    private void matchRank(int win) {
        switch (win) {
            case WIN_THREE -> fifth++;
            case WIN_FOUR -> fourth++;
            case WIN_FIVE -> third++;
            case WIN_SIX -> first++;
            case WIN_FIVE_BONUS -> second++;
        }
    }
}
