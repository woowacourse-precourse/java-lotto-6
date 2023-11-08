package lotto.dto;

import lotto.domain.WinningStatistics;

import java.util.List;

public class WinningResponseDto {

    private final List<Long> tier;
    private final int rankPrice;
    private final boolean isBonus;
    private final int correctCount;

    private WinningResponseDto(List<Long> tier, int rankPrice, boolean isBonus, int correctCount) {
        this.tier = tier;
        this.rankPrice = rankPrice;
        this.isBonus = isBonus;
        this.correctCount = correctCount;
    }

    public static WinningResponseDto create(WinningStatistics result, int correctCount) {
        return new WinningResponseDto(result.getTier(), result.getWinningPrice(), result.getBonusFlag(), correctCount);
    }

    public List<Long> getTier() {
        return tier;
    }

    public int getRankPrice() {
        return this.rankPrice;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
