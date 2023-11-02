package lotto.exception;

public class LottoNumberIsOverRangeException extends IllegalArgumentException {

    private static final String message = "로또 번호는 1~45까지만 입력할 수 있습니다.";

    public LottoNumberIsOverRangeException() {
        super(message);
    }
}
