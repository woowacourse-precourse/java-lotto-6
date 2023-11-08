package lotto.domain.lotto.opened;

import java.util.EnumMap;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.money.Money;

public final class LottoDrawingDataOpened {
    private final EnumMap<LottoPrize, Integer> data;

    private final Money totalCost;

    private final Money totalEarning;

    public LottoDrawingDataOpened(
            final EnumMap<LottoPrize, Integer> data,
            final Money totalCost,
            final Money totalEarning
    ) {
        this.data = data;
        this.totalCost = totalCost;
        this.totalEarning = totalEarning;
    }

    public EnumMap<LottoPrize, Integer> getData() {
        return data;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Money getTotalEarning() {
        return totalEarning;
    }
}
