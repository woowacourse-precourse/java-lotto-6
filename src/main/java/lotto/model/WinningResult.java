package lotto.model;

import static lotto.constant.WinningPrize.FIFTH_PLACE_AMOUNT;
import static lotto.constant.WinningPrize.FIRST_PLACE_AMOUNT;
import static lotto.constant.WinningPrize.FOURTH_PLACE_AMOUNT;
import static lotto.constant.WinningPrize.SECOND_PLACE_AMOUNT;
import static lotto.constant.WinningPrize.THIRD_PLACE_AMOUNT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record WinningResult(List<Integer> placeCounts) {
    public static WinningResult create() {
        return new WinningResult(List.of(0, 0, 0, 0, 0));
    }

    public WinningResult withIncreasedPlaceCount(final int placeIndex) {
        List<Integer> newCounts = new ArrayList<>(placeCounts);
        newCounts.set(placeIndex, placeCounts.get(placeIndex) + 1);
        return new WinningResult(newCounts);
    }

    public int getFirstPlaceCount() {
        return placeCounts.get(0);
    }

    public int getSecondPlaceCount() {
        return placeCounts.get(1);
    }

    public int getThirdPlaceCount() {
        return placeCounts.get(2);
    }

    public int getFourthPlaceCount() {
        return placeCounts.get(3);
    }

    public int getFifthPlaceCount() {
        return placeCounts.get(4);
    }

    public TotalWinningAmount getTotalWinningAmount() {
        BigDecimal totalWinningAmount = FIRST_PLACE_AMOUNT.getValue().multiply(BigDecimal.valueOf(placeCounts.get(0)))
                .add(SECOND_PLACE_AMOUNT.getValue().multiply(BigDecimal.valueOf(placeCounts.get(1))))
                .add(THIRD_PLACE_AMOUNT.getValue().multiply(BigDecimal.valueOf(placeCounts.get(2))))
                .add(FOURTH_PLACE_AMOUNT.getValue().multiply(BigDecimal.valueOf(placeCounts.get(3))))
                .add(FIFTH_PLACE_AMOUNT.getValue().multiply(BigDecimal.valueOf(placeCounts.get(4))));
        return new TotalWinningAmount(totalWinningAmount);
    }
}
