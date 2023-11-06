package lotto.constant;

import static lotto.constant.NumericConstant.LOTTO_PRICE;

public abstract class ErrorMessage {
    private static final String ERROR_HEADER = "[ERROR] ";
    public static final String ENTER_PROPER_NATURAL_NUMBER = ERROR_HEADER + "10억 이하의 자연수 값을 입력해주세요";
    public static final String NOT_DIVISIBLE_BY_LOTTO_PRICE = ERROR_HEADER + String.format("%d으로 나누어 떨어지는 값을 입력해 주세요.", LOTTO_PRICE);
}
