package lotto.exception;

import static lotto.Constants.LOTTO_PRICE;

public class ExceptionMessages {
    public static final String INVALID_PURCHASE_AMOUNT_MESSAGE =
            LOTTO_PRICE + " 이상의 " + LOTTO_PRICE + " 단위 정수를 입력해주세요.";
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_MESSAGE = "로또 번호는 중복되지 않아야 합니다.";
    public static final String OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_MATCH_COUNT_MESSAGE = "3 미만, 6 초과의 숫자는 Prize가 될 수 없습니다.";
    public static final String ONLY_NUMBER_INPUT_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String NEGATIVE_NUMBER_INPUT_MESSAGE = "음수는 입력할 수 없습니다.";
    public static final String DUPLICATE_BONUS_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
