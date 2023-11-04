package exception;

public class LottoException extends IllegalArgumentException{


    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String ERROR_NOT_A_NATURAL_NUMBER = "[ERROR] 숫자는 자연수여야 합니다.";

    public static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호에 중복된 숫자가 있습니다";
    public static final String ERROR_OUT_OF_RANGE_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoException(String message){
        super(message);
    }
}
