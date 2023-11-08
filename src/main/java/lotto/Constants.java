package lotto;

import java.util.regex.Pattern;

public class Constants {
        public static final String DELIMITER = ",";
        public static final int COST = 1000;
        public static final String LOTTO_RESULT = "\n당첨 통계";
        public static final String DASHES = "---";
        public static final String THREE_RESULT = "3개 일치 (5,000원) ";
        public static final String FOUR_RESULT = "4개 일치 (50,000원) ";
        public static final String FIVE_RESULT = "5개 일치 (1,500,000원) ";
        public static final String FIVE_BONUS_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) ";
        public static final String SIX_RESULT = "6개 일치 (2,000,000,000원) ";
        public static final String DASH = "- ";
        public static final String NUMBER = "개";
        public static final String QUANTITY_RESULT = "개를 구매했습니다.";
        public static final Pattern purchasePattern = Pattern.compile("^[0-9]+$");
        public static final Pattern stringPattern = Pattern.compile("^[0-9]+(" + DELIMITER + "[0-9]+)*$");

        public static final Pattern numPattern = Pattern.compile("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$");
        public static final String ERROR = "[ERROR] ";
        public static final String PURCHASE_WRONG_ERROR = ERROR + "구입 금액은 숫자만 입력해야 합니다.";
        public static final String PURCHASE_UNIT_ERROR = ERROR + "구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
        public static final String WINNING_NUMBER_WRONG_ERROR = ERROR + "당첨 번호는 쉼표로 구분된 비어있지 않은 숫자여야 합니다.";
        public static final String WINNING_NUMBER_DUPLICATE_ERROR = ERROR + "당첨 번호는 중복이 없어야 합니다.";
        public static final String WINNING_NUMBER_RANGE_WRONG_ERROR = ERROR + "당첨 번호는 1부터 45까지 범위의 수여야 합니다.";
        public static final String BONUS_NUMBER_WRONG_ERROR = ERROR + "보너스 번호는 숫자만 입력 해야 합니다.";
        public static final String BONUS_NUMBER_RANGE_WRONG_ERROR = ERROR + "보너스 번호는 1부터 45까지 범위의 수여야 합니다.";
        public static final String BONUS_NUMBER_DUPLICATE_ERROR = ERROR + "보너스 번호는 당첨 번호와 중복 되면 안 됩니다.";

}
