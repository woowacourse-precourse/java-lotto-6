package lotto.util;

public class Constant {

    public static class InputClass{
        public static final String COMMA = ",";
        public static final String ASK_MESSAGE_WINNING_NUMBER_LIST = "당첨 번호를 입력해 주세요.";

        public static final String ASK_MESSAGE_WINNING_BONUS_NUMBER_LIST = "보너스 번호를 입력해 주세요.";
        public static final String ASK_MESSAGE_LOTTO_CASH = "구입금액을 입력해 주세요.";
        public static final String PRINT_BUYING_LOTTO_LIST = "개를 구매했습니다.";
        public static final Integer TICKET_AMOUNT = 1000;
    }

    public static class OutputClass{
        public static final String PRINT_MESSAGE_WINNING_STATISTICS = "당첨 통계";
        public static final String PRINT_MESSAGE_WINNING_STATISTICS_LINE = "---";
        public static final String PRINT_MESSAGE_WINNING_HYPHEN = " - ";
        public static final String PRINT_MESSAGE_WINNING_COUNT = "개";
        public static final String PRINT_MESSAGE_TOTAL_PROCEEDS = "총 수익률은 ";
        public static final String PRINT_MESSAGE_TOTAL_PROCEEDS_PERCENTAGE = "%입니다.";
        public static final String DECIMAL_FORMAT = "###,##0.0";

    }

    public static class ModelClass{
        public static final Integer LOTTO_NUMBERS_LENGTH = 6;
        public static final Integer INITIALIZED_NUMBER = 0;
        public static final Integer BONUS_NUMBER_ENUM_COUNT = 7;

    }

    public static class Exception_MESSAGE{
        public static final String NOT_THOUSAND_AND_NEGATIVE_EXCEPTION = "[ERROR] 천원 단위로 입력해주세요.";
        public static final String DUPLICATE_NUMBER_EXCEPTION = "[ERROR] 로또번호가 중복 되었습니다.";
        public static final String SIX_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 총 6개여야 합니다.";
        public static final String NUMBER_FORMAT_EXCEPTION = "[ERROR] 숫자 형식으로 입력해주세요.";
        public static final String LOTTO_NUMBER_RANGE_EXCEPTION = "[ERROR] 로또 숫자 범위 이내로 입력해주세요.";
    }
}
