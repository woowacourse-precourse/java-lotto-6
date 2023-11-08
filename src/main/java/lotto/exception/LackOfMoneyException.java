package lotto.exception;

public class LackOfMoneyException extends LottoIllegalArgumentException {
    public LackOfMoneyException() {
        super("구입금액은 0보다 커야 합니다.");
    }
}
