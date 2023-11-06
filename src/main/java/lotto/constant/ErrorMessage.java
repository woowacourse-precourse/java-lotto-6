package lotto.constant;

public class ErrorMessage {
    public static final String NOT_A_NUMBER = "[ERROR] 숫자로 입력하셔야 됩니다!\n";
    public static final String IS_BLANK = "[ERROR] 입력값이 비어있습니다!\n";

    public static final String NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 구입 금액은 1000원 단위로 입력하셔야 됩니다!\n";
    public static final String AMOUNT_SMALL_THAN_THOUSAND = "[ERROR] 구입 금액은 1000원보다 커야 합니다!\n";

    public static final String WINNING_NUMBERS_SIZE_IS_SMALL = "[ERROR] 당첨 번호는 6개를 입력해야 합니다!\n";
    public static final String WINNING_NUMBERS_IS_DUPLICATED = "[ERROR] 당첨 번호는 중복되면 안됩니다!\n";
    public static final String WINNING_NUMBERS_IS_NOT_VALID_RANGE = "[ERROR] 당첨 번호는 1부터 45사이의 숫자로 입력하셔야 합니다.!\n";
}
