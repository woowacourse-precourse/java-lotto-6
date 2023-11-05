package domain;

import constant.WinningPrize;

import java.util.List;
import java.util.stream.IntStream;

public class GameResult {
    private final int money;
    private final List<Integer> winningRankCount;

    public GameResult(int money, List<Integer> winningRankCount) {
        this.money = money;
        this.winningRankCount = winningRankCount;
    }

    public double getRateOfReturn() {
        validateMoney();
        return (double) sumOfWinningPrize() / money * 100;
    }

    private void validateMoney() {
        if (money <= 0) {
            throw new RuntimeException();
        }
    }

    private int sumOfWinningPrize() {
        return IntStream.range(0, winningRankCount.size())
                .map(i -> winningRankCount.get(i) * getWinningPrize(i))
                .sum();
    }

    private int getWinningPrize(int rank) {
        return WinningPrize.values()[rank].get();
    }
}
