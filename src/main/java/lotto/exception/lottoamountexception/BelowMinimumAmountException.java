package lotto.exception.lottoamount;

public class BelowMinimumAmountException extends LottoAmountInputException {
    public BelowMinimumAmountException() {
        super("[ERROR] 로또 최소 구입 금액은 1000원 이상이어야 합니다.");
    }
}
