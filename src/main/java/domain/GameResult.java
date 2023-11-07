package domain;

import constant.WinningPrize;

import java.util.List;
import java.util.stream.IntStream;

public class GameResult {
    private final Money money;
    private final List<Integer> winningRankCount;

    public GameResult(Money money, List<Integer> winningRankCount) {
        this.money = money;
        this.winningRankCount = winningRankCount;
    }

    public double getRateOfReturn() {
        return money.getRateOfReturn(sumOfWinningPrize());
    }

    private int sumOfWinningPrize() {
        return IntStream.range(0, winningRankCount.size())
                .map(i -> winningRankCount.get(i) * getWinningPrize(i))
                .sum();
    }

    private int getWinningPrize(int rank) {
        return WinningPrize.values()[rank].get();
    }

    public List<Integer> getWinningRankCount() {
        return winningRankCount;
    }
}
