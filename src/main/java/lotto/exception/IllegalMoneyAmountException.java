package lotto.exception;

public class IllegalMoneyAmountException extends LottoIllegalArgumentException {
    public IllegalMoneyAmountException() {
        super("지불할 금액은 로또 가격으로 나누어 떨어져야 합니다.");
    }
}
