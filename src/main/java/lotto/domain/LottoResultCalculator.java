package lotto.domain;

import lotto.LottoTicket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoResultCalculator {
    public LottoResultCalculator() {
    }

    public List<Integer> calculateWinningResults(LottoTicket winningResult) {
        return new ArrayList<>();
    }

    public BigDecimal calculateTotalProfitRate(List<Integer> winningResults) {
        return BigDecimal.ZERO;
    }
}
