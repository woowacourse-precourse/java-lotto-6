package lotto.service;

import static lotto.view.OutputView.printResultsProfitability;

import java.math.BigDecimal;
import lotto.domain.Payment;
import lotto.domain.RankingResult;

public class ProfitabilityService {

    public void calculateProfitability(final Payment payment, final RankingResult rankingResult) {
        final BigDecimal profitability = rankingResult.receiveProfitability(payment);
        printResultsProfitability(profitability);
    }
}
