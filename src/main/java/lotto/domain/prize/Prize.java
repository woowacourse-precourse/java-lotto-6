package lotto.domain.prize;

import java.util.List;
import lotto.domain.purchasingMoney.PurchasingMoney;
import lotto.dto.WinStateInformationDTO;

public class Prize {

    private final long amount;

    public Prize(long amount) {
        this.amount = amount;
    }

    public static Prize from(List<WinStateInformationDTO> winStateInformationDTOs) {
        long entirePrizeCashAmount = winStateInformationDTOs.stream()
                .mapToLong(WinStateInformationDTO::getPrizeCashAmount)
                .sum();
        return new Prize(entirePrizeCashAmount);
    }

    public double getYield(PurchasingMoney cash) {
        return (double) this.amount * 100 / cash.amount();
    }

}
