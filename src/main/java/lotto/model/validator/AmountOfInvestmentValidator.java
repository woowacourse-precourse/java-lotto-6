package lotto.model.validator;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.util.AmountOfLotto.MAXIMUM_PRICE;
import static lotto.util.AmountOfLotto.MINIMUM_PRICE;
import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX;
import static lotto.util.ExceptionMessage.INVALID_INPUT_TYPE;
import static lotto.util.ExceptionMessage.NOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.util.ExceptionMessage.NOT_POSITIVE_INPUT;

/**
 * 투자금의 유효성을 검증한다.
 */
public class AmountOfInvestmentValidator {

    /**
     * 자료형을 검증한다.
     *
     * @param amountOfLotto String 자료형의 투자금
     * @throws IllegalArgumentException 숫자로 이루어져 있지 않을 경우
     */
    public static void checkType(String amountOfLotto) {
        if (!amountOfLotto.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    /**
     * 투자금의 범위를 검증한다.
     * 1원 ~ 2147483000원까지 투자할 수 있다.
     *
     * @param amountOfLotto 투자금
     * @throws IllegalArgumentException 투자금이 범위를 벗어나는 경우
     */
    public static void checkAmountWithinLottoPriceRange(long amountOfLotto) {
        checkMinimum(amountOfLotto);
        checkMaximum(amountOfLotto);
    }

    private static void checkMinimum(long amountOfLotto) {
        if (amountOfLotto < MINIMUM_PRICE.getPrice()) {
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    private static void checkMaximum(long amountOfLotto) {
        if (amountOfLotto > MAXIMUM_PRICE.getPrice()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX.getMessage());
        }
    }

    /**
     * 로또 금액인 1000원으로 나누어지는지 검증한다.
     *
     * @param amountOfLotto 투자금
     * @throws IllegalArgumentException 투자금이 로또 금액인 1000원으로 나누어지지 않을 경우
     */
    public static void checkDivideByLottoPrice(long amountOfLotto) {
        if (amountOfLotto % LOTTO_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
