package lotto;

public class Constants {

    public static final int LOTTERY_PRICE = 1000;
    public static final int LOTTERY_DIGIT_LENGTH = 6;
    public static final int LOTTERY_MIN_NUMBER = 1;
    public static final int LOTTERY_MAX_NUMBER = 45;
    public static final String ERROR_BLANK = "[ERROR] 입력된 값이 없습니다.";
    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해야합니다.";
    public static final String ERROR_NOT_MULTIPLE_1000 = "[ERROR] 1000단위로 나누어 떨어지는 숫자가 아닙니다.";
    public static final String ERROR_INCORRECT_LENGTH = "[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.";
    public static final String ERROR_INCORRECT_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATED_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_RESULT = "당첨 통계\n---\n";
    public static final String PURCHASE_RESULT = "%d개를 구매했습니다.\n";
    public static final String LOTTERY_RESULT = "%d개 일치 (%s) - %d개\n";
    public static final String LOTTERY_RESULT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";
    public static final String RETURN_RATE = "총 수익률은 %.1f%%입니다.";
}
