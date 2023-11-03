package exception;

public class ImpossiblePayAmountException extends CustomException {
    public ImpossiblePayAmountException() {
        super("구입 금액은 음수거나 0일 수 없습니다.");
    }
}
