package lotto.exception;

public class ImpossibleAmountException extends CustomException {
    public ImpossibleAmountException() {
        super("금액은 음수일 수 없습니다.");
    }
}
