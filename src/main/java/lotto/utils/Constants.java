package lotto.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_PRICE_PER_UNIT = 1000;
    public static final String BUY_PRICE_INSERT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_OUTPUT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_INSERT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INSERT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTIC_MESSAGE = "당첨 통계\n";
    public static final String HYPHENS = "---\n";
    public static final String RESULT_OUTPUT_FRONT_MESSAGE = "총 수익률은 ";
    public static final String RESULT_OUTPUT_BACK_MESSAGE = "%입니다.";
    public static final String HYPHEN = " - ";
    public static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원)";
    public static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원)";
    public static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원)";
    public static final String BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원)";
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String BUY_PRICE_PATTERN_ERROR = "로또 구입 금액은 숫자를 입력해야 합니다.";
    public static final String BUY_PRICE_UNIT_ERROR = "로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR = "각각 다른 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_STRING_ERROR = "당첨 번호는 '1,2'와 같이 숫자쉼표숫자의 형태로 입력해야하고 총 6개의 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "당첨 번호는 1부터 45사이의 숫자를 입력해야 합니다.";
    public static final String WINNING_NUMBER_ERROR = "당첨 번호는 숫자를 입력해야 합니다.";
    public static final Pattern BUY_PRICE_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern WINNING_NUMBER_STRING_PATTERN = Pattern.compile(
            "^[가-힣a-zA-Z0-9!@#$%^&*()_+]+(,[가-힣a-zA-Z0-9!@#$%^&*()_+]+){5}$");

}
