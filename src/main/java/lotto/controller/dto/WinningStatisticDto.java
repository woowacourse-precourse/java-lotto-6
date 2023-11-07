package lotto.controller.dto;

import java.util.List;
import lotto.model.domain.RankingBoard;

public class WinningStatisticDto {

    private List<Integer> count;
    private double yield;

    private WinningStatisticDto(List<Integer> count, double yield) {
        this.count = count;
        this.yield = yield;
    }

    public static WinningStatisticDto from(RankingBoard rankingBoard, double yield) {
        List<Integer> count = rankingBoard.getRanks().stream()
                .map(rank -> rank.getHeadCount())
                .toList();
        return new WinningStatisticDto(count, yield);
    }

    public List<Integer> getCount() {
        return count;
    }

    public double getYield() {
        return yield;
    }
}
