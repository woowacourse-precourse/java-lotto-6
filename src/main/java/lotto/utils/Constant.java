package lotto.utils;

public class Constant {
    public static final String FORMAT_ONE_DICIMAL = "#.##";
    public static final String FORMAT_PRICE = "#,###";
    public static final int SD_RANDOM_NUMBER_MIN = 1;
    public static final int SD_RANDOM_NUMBER_MAX = 45;
    public static final int COUNT_OF_LOTTO = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final String COMMA = ",";
    public static final String BLANK = " ";
    public static final String BRACKET_START = "(";
    public static final String BRACKET_END = ")";
    public static final String LINE = "-";

    public static class InputMessage {
        public static final String MSG_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
        public static final String MSG_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
        public static final String MSG_BONUS_NUMS = "보너스 번호를 입력해 주세요.";
    }

    public static class OutputMessage {
        public static final String MSG_LOTTO_QUANTITY = "개를 구매했습니다.";
        public static final String MSG_WINNING_STATISTICS = "당첨 통계";
        public static final String MSG_LINE = "---";
        public static final String MSG_WINNING_WITH_BONUSNUM = "5개 일치, 보너스 볼 일치";
        public static final String MSG_WINNING_WITHOUT_BONUSNUM = "개 일치";
        public static final String MSG_MONEY_UNIT = "원";
        public static final String MSG_COUNT_UNIT = "개";
        public static final String MSG_RATE_OF_RETURN_FIRST = "총 수익률은 ";
        public static final String MSG_RATE_OF_RETURN_END = "%입니다.";
    }

    public static class ErrorMessage {
        public static final String ERROR_PURCHASE_PRICE_NUM = "[ERROR] 구입금액은 숫자여야 합니다.";
        public static final String ERROR_WINNINGNUM_NUM = "[ERROR] 당첨 번호는 숫자여야 합니다.";
        public static final String ERROR_BONUSNUM_NUM = "[ERROR] 보너스 번호는 숫자여야 합니다.";
        public static final String ERROR_WINNINGNUM_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
        public static final String ERROR_WINNINGNUM_DUPLICATION = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
        public static final String ERROR_BONUSNUM_DUPLICATION = "[ERROR] 당첨 번호에 포함된 보너스 번호입니다.";
        public static final String ERROR_WINNINGNUM_RANGE = "[ERROR] 당첨 숫자는 1에서 45 사이여야 합니다.";
        public static final String ERROR_PURCHASE_PRICE = "[ERROR] 로또 1개의 가격은 1,000원입니다. 올바른 구입금액을 입력하셔야 합니다.";

    }
}
