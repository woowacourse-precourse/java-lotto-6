package lotto.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String BUY_PRICE_PATTERN_ERROR = "로또 구입 금액은 숫자를 입력해야 합니다.";
    public static final String BUY_PRICE_UNIT_ERROR = "로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR = "각각 다른 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_ERROR = "당첨 번호는 숫자를 입력해야 합니다.";
    public static final Pattern BUY_PRICE_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
}
