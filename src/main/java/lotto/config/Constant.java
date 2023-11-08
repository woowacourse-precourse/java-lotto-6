package lotto.config;

public class Constant {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final int TICKET_PRICE = 1000;

    public static final int WINNING_FIRST = 2_000_000_000;
    public static final int WINNING_SECOND = 30_000_000;
    public static final int WINNING_THIRD = 1_500_000;
    public static final int WINNING_FOURTH = 50_000;
    public static final int WINNING_FIFTH = 5_000;

    public static final String NUMBER_SIZE_EXCEPTION = "당첨 번호는 6개의 숫자를 입력 바랍니다";
    public static final String NUMBER_RANGE_EXCEPTION = "1 부터 45 까지의 숫자를 입력해 주세요.";
    public static final String DUPLICATE_NUMBER_EXCEPTION = "중복된 수는 입력할 수 없습니다.";
    public static final String DEPOSIT_UNIT_EXCEPTION = "금액은 1,000원 단위로 입력해주세요.";
    public static final String NUMBER_FORMAT_EXCEPTION = "정수형 수를 입력해주세요.";

    public static final String INPUT_DEPOSIT = "구매금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String ERROR_ALARM = "[ERROR] ";

}
