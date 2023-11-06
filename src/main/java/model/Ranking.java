package model;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private final List<Integer> winningDetails = new ArrayList<>();

    public void addRank(int rank){
        winningDetails.add(rank);
    }

    public List<Integer> getWinningDetails() {
        return winningDetails;
    }
}
