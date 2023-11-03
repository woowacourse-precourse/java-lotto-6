package lotto.domain;

import java.util.List;

public class TotalWinning {
    private final int amount;

    public TotalWinning(List<Integer> ranking) {
        int total = 0;
        for(int rank : ranking) {
            total += rank;
        }
        this.amount = total;
    }
}