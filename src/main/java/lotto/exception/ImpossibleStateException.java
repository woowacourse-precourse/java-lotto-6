package lotto.exception;

public class ImpossibleStateException extends IllegalStateException {
    public ImpossibleStateException() {
        super("존재할 수 없는 상태입니다.");
    }
}
