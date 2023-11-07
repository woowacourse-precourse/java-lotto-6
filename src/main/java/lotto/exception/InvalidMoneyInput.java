package lotto.exception;

public class InvalidMoneyInput extends LottoIllegalArgumentException {
    public InvalidMoneyInput() {
        super("숫자가 아닌 값이 포함되어 있습니다.");
    }
}
