package lotto.domain.lottery;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import static lotto.domain.lottery.constants.LottoConstraint.*;

public class LottoService {
    private static final BigDecimal BIG_DECIMAL_ZERO = BigDecimal.ZERO;
    private static final BigDecimal PERCENT = new BigDecimal(100);
    private static final int INT_ZERO = 0;

    private LottoService() {
    }

    public static List<Integer> generateOrderedLottoNumbers() {
        List<Integer> randomNumbers = generateLottoNumber();
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                NUMBER_LOWER_BOUND.getValue(),
                NUMBER_UPPER_BOUND.getValue(),
                LOTTO_PICK_COUNT.getValue()
        );
    }

    public static BigDecimal calculateFinalYield(
            int payment,
            long income
    ) {
        if (income == INT_ZERO) {
            return BIG_DECIMAL_ZERO;
        }

        BigDecimal castedIncome = new BigDecimal(income);
        BigDecimal castedPayment = new BigDecimal(payment);

        return castedIncome
                .multiply(PERCENT)
                .divide(castedPayment, 1, RoundingMode.HALF_UP);
    }
}
