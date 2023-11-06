package lotto.exception.lottonumbers;

public class NonDuplicateNumbersException extends LottoNumbersInputException {
    public NonDuplicateNumbersException() {
        super("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
