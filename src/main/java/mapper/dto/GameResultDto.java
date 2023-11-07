package mapper.dto;

import constant.WinningPrize;

import java.util.List;

public class GameResultDto {
    private final double rateOfReturn;
    private final List<Integer> winningRankCount;

    public GameResultDto(double rateOfReturn, List<Integer> winningRankCount) {
        this.rateOfReturn = rateOfReturn;
        this.winningRankCount = winningRankCount;
    }

    public int getRankCount(int rank) {
        return winningRankCount.get(rank - 1);
    }

    public int getWinningPrize(int rank) {
        return WinningPrize.values()[rank - 1].get();
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
