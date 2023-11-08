package lotto.exception;

public class InvalidMoneyInputException extends LottoIllegalArgumentException {
    public InvalidMoneyInputException() {
        super("숫자가 아닌 값이 포함되어 있습니다.");
    }
}
