package lotto.domain.prize;

import java.util.List;
import lotto.domain.purchasingMoney.PurchasingMoney;
import lotto.dto.WinningStatisticDTO;

public class Prize {

    private final long amount;

    public Prize(long amount) {
        this.amount = amount;
    }

    public static Prize from(List<WinningStatisticDTO> winningStatisticDTOs) {
        long entirePrizeCashAmount = winningStatisticDTOs.stream()
                .mapToLong(WinningStatisticDTO::getPrizeCashAmount)
                .sum();
        return new Prize(entirePrizeCashAmount);
    }

    public double getYield(PurchasingMoney cash) {
        return (double) this.amount * 100 / cash.amount();
    }

}
