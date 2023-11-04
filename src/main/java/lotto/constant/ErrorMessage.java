package lotto.constant;

public class ErrorMessage {

    public static final String PURCHASE_WRONG
            = "[ERROR] 구입금액은 1000원 단위로 입력해야합니다.";

    public static final String WINNING_NUMBER_SIZE
            = "[ERROR] 당첨번호는 6자리로 입력해야합니다.";

    public static final String WINNING_NUMBER_DUPLICATE
            = "[ERROR] 당첨번호는 중복될 수 없습니다.";

    public static final String WINNING_NUMBER_RANGE
            = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String BONUS_NUMBER_RANGE
            = "[ERROR] 보너스번호는 1부터 45 사이의 숫자여야 합니다.";
}
