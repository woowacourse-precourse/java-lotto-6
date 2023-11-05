package lotto.Util;

import java.util.regex.Pattern;

public class Rule {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int MAX_LENGTH = 6;
    public static final int MIN_LENGTH = 1;
    public static final int BONUSNUM_LENGTH = 1;

    public static final Pattern LottoNumberPattern = Pattern.compile("^[1-9][0-9]*$");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final Pattern WINNUNG_PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    public static final String ERROR ="[ERROR]" ;
    public static final String LOTTO_NUM_DUPLICATE_ERROR = ERROR + "중복된 숫자가 포함되어있습니다";
    public static final String LOTTO_NUM_RANGE = ERROR + MIN_NUMBER + "부터" + MAX_NUMBER + "까지의 숫자만 입력가능합니다.";
    public static final String LOTTO_NUM_SIZE_ERROR = ERROR + "6개의 번호를 입력해야 합니다";
    public static final String NOTNUMBER_PATTERN = ERROR + "당첨번호의 입력 형식이 맞지 않습니다.";
    public static final String LOTTO_BUY_ERROR = ERROR + "1000원 단위의 금액만 입력할 수 있습니다";
    public static final String WINNING_RESULT = "\n 당첨통계 " + "\r\n --- ";
}
