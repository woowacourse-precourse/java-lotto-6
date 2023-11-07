package exception;

public class DuplicateBonusNumberException extends IllegalArgumentException{
    private static final String message = "보너스 번호가 로또 번호에 포함되어 있습니다.";

    public DuplicateBonusNumberException() {
        super(message);
    }

}