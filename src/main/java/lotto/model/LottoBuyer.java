package lotto.model;

import static lotto.model.LottoManager.AMOUNT_UNIT;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoBuyer {
    private final List<Lotto> lottos;
    private final Map<LottoGrade, Integer> result = new EnumMap<>(LottoGrade.class);

    public LottoBuyer(final int amount, final LottoManager lottoManager) {
        lottos = lottoManager.createLottoTickets(amount);
        initializeResult();
    }

    private void initializeResult() {
        for (final LottoGrade lottoGrade : LottoGrade.values()) {
            result.put(lottoGrade, 0);
        }
    }

    public Map<LottoGrade, Integer> calculateResult(final LottoResult lottoResult) {
        for (final Lotto lotto : lottos) {
            final LottoGrade lottoGrade = lottoResult.calculateGrade(lotto);
            if (lottoGrade != null) {
                result.put(lottoGrade, result.get(lottoGrade) + 1);
            }
        }
        return Collections.unmodifiableMap(result);
    }

    public double returnOnInvestment() {
        double amount = 0;
        for (final Map.Entry<LottoGrade, Integer> entry : result.entrySet()) {
            final Integer winningCount = entry.getValue();
            if (winningCount > 0) {
                amount += entry.getKey().getAmount() * winningCount;
            }
        }
        return calculateReturnOnInvestment(amount);
    }

    private double calculateReturnOnInvestment(final double amount) {
        if (amount == 0) {
            return amount;
        }
        return (amount / (lottos.size() * AMOUNT_UNIT)) * 100;
    }
}
