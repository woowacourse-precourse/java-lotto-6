package lotto.constant;

import java.util.regex.Pattern;

public class Magic {
    public static final Pattern NUMBER_POSITIVE = Pattern.compile(
            "[1-9]\\d*"); //cacheing to stop regenerating pattern instance
    public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String PRINT_BUYNUMBER = "개를 구매했습니다.";
    public static final String EXECUTE_RESULT = "\n당첨 통계\n---\n";
    public static final int LOTTO_PRICE = 1000;
    public static final int STRAT_INRANGE = 1;
    public static final int END_INRANGE = 45;
    public static final int NUMBERS_INLOTTO = 6;
}
