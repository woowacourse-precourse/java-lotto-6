package lotto.message;

public class ErrorMessage {

    public static final String ERROR_INPUT_MONEY = "[ERROR] 1000원 단위의 금액을 입력하세요.";
    public static final String ERROR_INPUT_INT = "[ERROR] 잘못된 형식의 숫자 입력입니다.";
    public static final String ERROR_LOTTO_NUM_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String ERROR_LOTTO_NUM_SCOPE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_NUM_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String ERROR_BONUS_NUM_DUPLICATE = "[ERROR] 당첨숫자와 보너스 숫자가 중복됩니다.";

    private ErrorMessage() {
    }

}
