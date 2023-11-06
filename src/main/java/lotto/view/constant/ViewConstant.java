package lotto.view.constant;

public class ViewConstant {
    public static class InputViewConstant {
        public static final String COMMA = ",";
        public static final String NUMBERS_FORMAT_REGEX = "([0-9]+,?)+";
        public static final String NUMBER_REGEX = "[0-9]+";
        public static final long LOTTO_PRICE = 1000L;
        public static final long ZERO = 0L;
        public static final int MIN_RANGE = 1;
        public static final int MAX_RANGE = 45;
        public static final int NUMBERS_COUNT = 6;
        public enum InputErrorMessage {
            NOT_EXIST_INPUT_ERROR("[ERROR] 입력이 존재하지 않습니다."),
            NOT_CONTAINS_ONLY_NUMBER("[ERROR] 숫자 이외의 문자는 포함될 수 없습니다."),
            NOT_THOUSAND_UNIT("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
            UNDER_THOUSAND_AMOUNT("[ERROR] 최소 1000원의 금액을 입력해야 합니다."),
            WINNING_NUMBERS_INVALID_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다."),
            NOT_SIX_NUMBERS("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다."),
            DUPLICATED_BONUS_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."),
            NOT_NUMBER("[ERROR] 값은 숫자만 가능합니다."),
            OVER_RANGE("[ERROR] 숫자 범위는 1부터 45까지 가능합니다.");

            private final String errorMessage;

            InputErrorMessage(final String errorMessage) {
                this.errorMessage = errorMessage;
            }

            public String getErrorMessage() {
                return errorMessage;
            }
        }
    }

    public static class OutputViewConstant {
        public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
        public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
        public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
        public static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
        public static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
        public static final String STATUS = "당첨 통계";
        public static final String THREE_DASH = "---";
        public static final String NEW_LINE = System.getProperty("line.separator");
        public static final int HUNDRED = 100;
    }
}
