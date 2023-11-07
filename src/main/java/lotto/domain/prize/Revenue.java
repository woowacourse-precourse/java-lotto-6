package lotto.domain.prize;

import lotto.domain.lottery.Buyer;
import lotto.service.LottoService;

import java.math.BigDecimal;

public class Revenue {
    private final long income;
    private final BigDecimal yield;

    // Constructor
    private Revenue(
            final Buyer buyer,
            final FinalResults finalResults
    ) {
        final int payment = buyer.getPayment();

        this.income = finalResults.calculateFinalRevenueAmount();
        this.yield = LottoService.calculateFinalYield(payment, income);
    }

    // Static Factory Method
    public static Revenue of(
            final Buyer buyer,
            final FinalResults finalResults
    ) {
        return new Revenue(buyer, finalResults);
    }

    // Getter
    public BigDecimal getYield() {
        return yield;
    }
}
