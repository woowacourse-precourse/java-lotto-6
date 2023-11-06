package lotto.exception.lottonumbersexception;

public class InsufficientNumbersCountException extends LottoNumbersInputException {
    public InsufficientNumbersCountException() {
        super("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
