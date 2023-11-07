package lotto.constant;

public class ExceptionMessage {

    public static final String NOT_NUMBER_MESSAGE = "[ERROR] 숫자가 아닌 문자가 들어 있습니다. 숫자를 입력해주세요.";
    public static final String OUT_OF_LOTTO_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LENGTH_ERROR_MESSAGE = "[ERROR] 입력한 숫자의 길이가 맞지 않습니다.";
    public static final String DUPLICATION_MESSAGE = "[ERROR] 중복된 숫자가 입력되었습니다.";
    public static final String NOT_POSITIVE_MESSAGE = "[ERROR] 입력한 숫자가 양수가 아닙니다.";
    public static final String NOT_UNIT_NUMBER_MESSAGE = "[ERROR] 입력한 숫자의 단위가 잘못되었습니다.";
    public static final String BONUS_NUMBER_OVERLAPPED_MESSAGE = "[ERROR] 입력한 보너스` 숫자가 겹칩니다.";

    private ExceptionMessage() {
    }


}
