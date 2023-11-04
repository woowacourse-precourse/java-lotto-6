package exception;

public class LottoException extends IllegalArgumentException{


    public static final String checkAmountValidity = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String validateNaturalNumber = "[ERROR] 숫자는 자연수여야 합니다.";



    public LottoException(String message){
        super(message);
    }
}
