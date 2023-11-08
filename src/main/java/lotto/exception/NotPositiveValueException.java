package lotto.exception;

public abstract class NotPositiveValueException extends CustomException {
    public NotPositiveValueException(String valueName) {
        super(valueName + "값은 양수여야 합니다.");
    }
}
