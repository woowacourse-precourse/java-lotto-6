package lotto.message;

public class ErrorMessage {

    public static final String ERROR = "[ERROR]";
    public static final String NOT_MULTIPLES_OF_THOUSANDS = ERROR + " 로또 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String NOT_NUMBER_FORMAT = ERROR + " 숫자를 입력해야 합니다.";
    public static final String NOT_SIX_NUMBERS = ERROR + " 로또 번호는 6개의 숫자로 구성되어야 합니다.";
    public static final String OUT_OF_RANGE = ERROR + " 로또 번호는 1부터 45 사이의 유효한 숫자여야 합니다.";
    public static final String NOT_UNIQUE_NUMBER = ERROR + " 로또 번호는 중복되지 않은 유효한 숫자여야 합니다.";

}
