package lotto.constant;

import static lotto.constant.GameOptions.MAX_NUMBER;
import static lotto.constant.GameOptions.MIN_NUMBER;
import static lotto.constant.GameOptions.NUMBER_COUNT;
import static lotto.constant.GameOptions.PRICE;

public enum ExceptionMessages {
    PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE("구입금액은 양의 정수여야 합니다."),
    WINNING_NUMBER_FORMAT_EXCEPTION_MESSAGE("당첨 번호는 ,로 구분된 양의 정수의 배열이어야 합니다."),
    BONUS_NUMBER_FORMAT_EXCEPTION_MESSAGE("보너스 번호는 양의 정수여야 합니다."),
    MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE("로또 구입 금액은 " + PRICE.getValue() + " 이상이어야 합니다."),
    PURCHASE_AMOUNT_DIVISIBILITY_EXCEPTION_MESSAGE("로또 구입 금액은 " + PRICE.getValue() + "로 나누어 떨어져야 합니다."),
    WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE("당첨 번호의 개수는 " + NUMBER_COUNT.getValue() + "개여야 합니다."),
    WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE(
            "당첨 번호는 " + MIN_NUMBER.getValue() + " ~ " + MAX_NUMBER.getValue() + " 사이의 값이어야 합니다."),
    WINNING_NUMBER_DUPLICATION_EXCEPTION_MESSAGE("당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_DUPLICATION_EXCEPTION_MESSAGE("보너스 번호는 당첨 번호와 중복될 수 없습니다");


    private String value;

    private ExceptionMessages(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
