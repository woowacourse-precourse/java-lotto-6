package lotto.configuration;

public class Constants {

    public static final class Error {
        public static final String MESSAGE = "[ERROR] ";

        public static final String NEED_MULTIPLE_OF_PRICE = "의 배수의 숫자를 입력해야 합니다.";
        public static final String CONVERT_NUMBER_ERROR = "숫자 변환에 실패했습니다.";
    }

    public static final class Rule {
        public static final int PRICE = 1000;
        public static final String DELIM = ",";
    }


    public static final class Message {
        public static final String NEED_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
        public static final String BUY_LOTTO =  "개를 구매했습니다.\n";

    }

}
