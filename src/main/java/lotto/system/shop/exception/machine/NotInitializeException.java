package lotto.system.shop.exception.machine;

public class NotInitializeException extends IllegalStateException {

    private static final String NOT_INITIALIZE_LOTTO_MACHINE_MESSAGE = "로또 기계를 초기화 해주세요.";

    public NotInitializeException() {
        super(NOT_INITIALIZE_LOTTO_MACHINE_MESSAGE);
    }
}
