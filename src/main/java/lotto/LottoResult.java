package lotto;

import static lotto.LottoCriteria.FIFTH_PLACE;
import static lotto.LottoCriteria.FIRST_PLACE;
import static lotto.LottoCriteria.FOURTH_PLACE;
import static lotto.LottoCriteria.SECOND_PLACE;
import static lotto.LottoCriteria.THIRD_PLACE;

import java.util.List;
import java.util.Map;

public class LottoResult {

    private final WinningNumber winningNumber;
    private final List<Lotto> issuedLotto;
    private Map<String, Long> result;

    public LottoResult(final WinningNumber winningNumber, final List<Lotto> issuedLotto) {
        this.winningNumber = winningNumber;
        this.issuedLotto = issuedLotto;
    }

    public long matchingCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningNumber.lotto().getNumbers()::contains)
                .count();
    }

    public float returnCalculation(final Map<String, Long> result, Long price) {
        Long totalAmount = result.get(FIFTH_PLACE.getPlace()) * FIFTH_PLACE.getAmount()
                + result.get(FOURTH_PLACE.getPlace()) * FOURTH_PLACE.getAmount()
                + result.get(THIRD_PLACE.getPlace()) * THIRD_PLACE.getAmount()
                + result.get(SECOND_PLACE.getPlace()) * SECOND_PLACE.getAmount()
                + result.get(FIRST_PLACE.getPlace()) * FIRST_PLACE.getAmount();
        return (float) totalAmount / price * 100;
    }
}
