package lotto.domain.lottery;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.lottery.constants.LottoConstraint.*;

public class LottoService {
    private static final BigDecimal PERCENT = new BigDecimal(100);
    private static final int DECIMAL_PLACES = 1;

    // Default Constructor
    private LottoService() {
    }

    // Utility Method
    public static List<Integer> generateOrderedLottoNumbers() {
        List<Integer> randomNumbers = generateLottoNumber();
        List<Integer> copiedNumbers = new ArrayList<>(randomNumbers);

        copiedNumbers.sort(null);
        return copiedNumbers;
    }

    private static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                NUMBER_LOWER_BOUND.getValue(),
                NUMBER_UPPER_BOUND.getValue(),
                LOTTO_PICK_COUNT.getValue()
        );
    }

    public static BigDecimal calculateFinalYield(
            final int payment,
            final long income
    ) {
        BigDecimal castedIncome = new BigDecimal(income);
        BigDecimal castedPayment = new BigDecimal(payment);

        return castedIncome
                .multiply(PERCENT)
                .divide(castedPayment,
                        DECIMAL_PLACES,
                        RoundingMode.HALF_UP);
    }

    public static List<Lotto> generateLottos(final int ticketCount) {
        List<List<Integer>> generatedLottoNumbers = generateRandomNumbers(ticketCount);

        return generatedLottoNumbers
                .stream()
                .map(Lotto::new)
                .toList();
    }

    private static List<List<Integer>> generateRandomNumbers(final int ticketCount) {
        return Stream.generate(LottoService::generateOrderedLottoNumbers)
                .limit(ticketCount)
                .toList();
    }
}
