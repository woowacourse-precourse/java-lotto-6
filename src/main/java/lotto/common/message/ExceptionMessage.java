package lotto.common.message;

public class ExceptionMessage {

    public static final String INPUT_PRICE_CHECK= "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    public static final String NON_NUMBER_CHECK = "[ERROR] 로또 번호 및 금액은 숫자만 입력 가능합니다.";
    public static final String ZERO_CHECK = "[ERROR] 로또 번호 및 금액은 0원을 입력할 수 없습니다.";
    public static final String START_ZERO_CHECK = "[ERROR] 로또 금액은 0으로 시작할 수 없습니다";
    public static final String NUMERIC_LENGTH_CHECK = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.";
    public static final String DUPLICATED_NUMBER_CHECK = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String WINNER_NUMBER_RANGE_CHECK = "[ERROR] 로또 번호는 1에서 45 사이만 입력 가능합니다.";
    public static final String WINNER_NUMBER_BLANK_CHECK = "[ERROR] 로또 번호는 공백 입력이 불가능합니다.";
    public static final String BONUS_NUMBER_CHECK = "[ERROR] 로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.";


    private ExceptionMessage() {
    }
}
