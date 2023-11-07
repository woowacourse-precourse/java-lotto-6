package lotto.message;

import static lotto.constant.TextColor.ERROR;

public class ErrorMessage {
    public static final String TEMPLATE = ERROR + "[ERROR] %s";
    public static final String NOT_INTEGER = String.format(TEMPLATE, "정수를 입력해주세요.");
    public static final String INVALID_AMOUNT = String.format(TEMPLATE, "입력한 가격은 1000원 단위여야 합니다.");
    public static final String INVALID_INPUT_LOTTO_NUMBER_COUNT = String.format(TEMPLATE, "당첨 번호는 6개여야 합니다.");
    public static final String OUT_OF_RANGE = String.format(TEMPLATE, "로또 번호는 1에서 45 사이입니다.");
    public static final String DUPLICATE = String.format(TEMPLATE, "로또 번호와 보너스 번호는 모두 다른 숫자여야 합니다.");
}
