package lotto.constant;

public class ErrorMessage {
    public static final String NOT_A_NUMBER = "숫자로 입력하셔야 됩니다!\n";
    public static final String IS_BLANK = "입력값이 비어있습니다!\n";
    public static final String NOT_MULTIPLE_OF_THOUSAND = "구입 금액은 1000원 단위로 입력하셔야 됩니다!\n";
    public static final String AMOUNT_SMALL_THAN_THOUSAND = "구입 금액은 1000원보다 커야 합니다!\n";
    public static final String WINNING_NUMBERS_SIZE_IS_SMALL = "당첨 번호는 6개를 입력해야 합니다!\n";
    public static final String WINNING_NUMBERS_IS_DUPLICATED = "당첨 번호는 중복되면 안됩니다!\n";
    public static final String WINNING_NUMBERS_IS_NOT_VALID_RANGE = "당첨 번호는 1부터 45사이의 숫자로 입력하셔야 합니다!\n";
    public static final String BONUS_IS_DUPLICATED = "보너스 번호는 당첨 번호와 중복되면 안됩니다!\n";
    public static final String LOTTO_SIZE_IS_SMALL = "로또 번호는 6개여야 합니다!\n";
    public static final String LOTTO_IS_DUPLICATED = "로또 번호는 중복되면 안됩니다!\n";
    public static final String LOTTO_IS_NOT_VALID_RANGE = "로또 번호는 1부터 45사이의 숫자여야 합니다!\n";
    private ErrorMessage() {

    }
}
