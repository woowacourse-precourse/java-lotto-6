package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_AMOUNT_DIVISION_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.TOO_LONG_INPUT_ERROR_MESSAGE;
import static lotto.config.LottoConfig.LOTTO_AMOUNT;
import static lotto.config.LottoConfig.MAX_INPUT_LENGTH;
import static lotto.config.LottoConfig.MAX_LOTTO_COUNT;

/**
 * 사용자가 입력한 구입 금액 입력값 검사
 */
public class PurchaseAmountValidator extends Validator<String> {
    /**
     * 9자리 이하의 숫자로만 이루어져있고 1000으로 나누어 떨어지면서 10000장 미만을 구매한 입력값만 통과
     * @param input 사용자가 입력한 구입 금액
     * @return 검증된 문자열 반환
     */
    @Override
    public String valid(String input) {
        if (isTooLongString(input)) {
            throw new IllegalArgumentException(TOO_LONG_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE.getMessage());
        }
        if (!isDivisibleByThousand(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_DIVISION_ERROR_MESSAGE.getMessage());
        }
        if (isTooLargeNumber(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE.getMessage());
        }
        return input;
    }

    private boolean isTooLongString(String input) {
        return input.length() > MAX_INPUT_LENGTH.getValue();
    }

    private boolean isDivisibleByThousand(String input) {
        return toInteger(input) % LOTTO_AMOUNT.getValue() == 0;
    }

    private boolean isTooLargeNumber(String input) {
        return toInteger(input) / LOTTO_AMOUNT.getValue() >= MAX_LOTTO_COUNT.getValue();
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
