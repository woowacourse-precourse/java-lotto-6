package lotto.exception.lottoamountexception;

public class NotDivisibleByThousandException extends LottoAmountInputException {
    public NotDivisibleByThousandException() {
        super("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
}
