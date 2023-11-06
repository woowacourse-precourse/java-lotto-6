package lotto.exception.lottonumbersexception;

public class OutOfNumbersRangeException extends LottoNumbersInputException {
    public OutOfNumbersRangeException() {
        super("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
    }
}
