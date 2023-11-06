package lotto.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String BUY_PRICE_PATTERN_ERROR = "로또 구입 금액은 숫자를 입력해야 합니다.";
    public static final String BUY_PRICE_UNIT_ERROR = "로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR = "각각 다른 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_STRING_ERROR = "당첨 번호는 '1,2'와 같이 숫자쉼표숫자의 형태로 입력해야하고 총 6개의 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "당첨 번호는 1부터 45사이의 숫자를 입력해야 합니다.";
    public static final Pattern BUY_PRICE_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern WINNING_NUMBER_RANGE = Pattern.compile("^[0-9]|[1-3][0-9]|4[0-5]*$");
    public static final Pattern WINNING_NUMBER_STRING_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9!@#$%^&*()_+]+(,[a-zA-Z0-9!@#$%^&*()_+]+){5}$");

}
