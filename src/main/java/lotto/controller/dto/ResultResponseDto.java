package lotto.controller.dto;

import java.text.DecimalFormat;

public class ResultResponseDto {

    private final int sameNumberCount;
    private final int winnerPrice;
    private final boolean hasBonus;
    private final int totalCount;

    public ResultResponseDto(int sameNumberCount, int winnerPrice, boolean hasBonus,
            int totalCount) {
        this.sameNumberCount = sameNumberCount;
        this.winnerPrice = winnerPrice;
        this.hasBonus = hasBonus;
        this.totalCount = totalCount;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public String getWinnerPrice() {
        return toDecimalFormat(winnerPrice);
    }

    private String toDecimalFormat(int number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
