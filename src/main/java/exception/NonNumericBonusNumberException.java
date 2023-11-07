package exception;

public class NonNumericBonusNumberException extends IllegalArgumentException {

    private static final String message = "입력된 보너스 번호가 숫자가 아닙니다.";

    public NonNumericBonusNumberException() {
        super(message);
    }
}