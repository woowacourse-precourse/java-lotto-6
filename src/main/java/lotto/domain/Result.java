package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    static final int RANK_NUMBER = 6;

    private List<Integer> ranks;
    private double income = 0;

    public Result() {
        ranks = new ArrayList<Integer>();
        for (int i = 0; i < RANK_NUMBER; i++) {
            ranks.add(0);
        }
    }

    public void countRank(int rank) {
        ranks.set(rank - 1, ranks.get(rank - 1) + 1);
    }

    public void addIncome(int income){
        this.income += income;
    }

    public List<Integer> getRanks() {
        return ranks;
    }

    public double getIncome(){
        return income;
    }
}
