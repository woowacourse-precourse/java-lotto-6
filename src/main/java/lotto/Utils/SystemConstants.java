package lotto.Utils;

public class SystemConstants {
    public static final int MIN_L0TTO_NUMBER = 1;
    public static final int MAX_L0TTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public final static int DIVIDED_NUMBER = 1000;

    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.";
    public static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String PURCHASE_MESSAGE = "\n%S개를 구매했습니다.";
    public static final String WINNING_RESULT_MESSAGE = """
                            
            당첨 통계
            ---""";
    public static final String COUNT_MESSAGE = "개";
    public static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %s%%입니다.";
    public static final String ROUND_TO_TWO = "%.1f";

    public final static String PURCHASE_MONEY_NOT_DIVIDED_1000 = "[ERROR] 1000 단위의 금액을 입력해야 합니다.\n";
    public final static String NOT_NUMBER = "[ERROR] 숫자를 입력해야 합니다.\n";
    public final static String SIX_LOTTO_NUMBER = "[ERROR] 1~45 범위 안에서 중복없이 6개의 숫자를 입력해야 합니다.";
    public final static String NOT_IN_LOTTO_NUMBER = "[ERROR] 1~45 범위 안에서 당첨 번호와 중복되지 않아야 합니다.";
}
