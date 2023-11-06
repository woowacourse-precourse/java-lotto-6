package exception;

public class ImpossibleStateException extends CustomException {
    public ImpossibleStateException() {
        super("존재할 수 없는 상태입니다.");
    }
}
