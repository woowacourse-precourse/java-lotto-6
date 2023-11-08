package lotto.constant;

import static lotto.constant.GameNumber.BONUS_NUMBER_COUNT;
import static lotto.constant.GameNumber.MAX_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MIN_NUMBER;
import static lotto.constant.GameNumber.NORMAL_NUMBER_COUNT;

public enum ErrorMessage {

    ONLY_NUMBERS_ALLOWED("숫자만 입력해야 합니다."),

    WRONG_MINIMUM_BUY(MIN_LOTTO_AMOUNT + "개 이상 구매해야 합니다."),
    WRONG_MAXIMUM_BUY("최대 " + MAX_LOTTO_AMOUNT + "개까지 구매할 수 있습니다."),
    WRONG_BUY_PRICE("금액은 1,000원 단위로 입력해야 합니다."),

    ONLY_NUMBERS_COMMA_ALLOWED("숫자 및 쉼표(,)만 입력해야 합니다."),
    BAD_COMMA_POSITION("각각의 숫자를 쉼표(,)로 구분하여 입력해 주세요."),
    WRONG_NORMAL_NUMBER_COUNT("로또 번호는 " + NORMAL_NUMBER_COUNT + "개 입력해야 합니다."),
    WRONG_BONUS_NUMBER_COUNT("보너스 번호는 " + BONUS_NUMBER_COUNT + "개 입력해야 합니다."),
    NO_DUPLICATION_ALLOWED("중복되는 번호가 있어서는 안 됩니다."),
    WRONG_NUMBER_RANGE("로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
