package lotto.exception.lottonumbersexception;

public class DuplicateBonusNumberException extends LottoNumbersInputException {
    public DuplicateBonusNumberException() {
        super("[ERROR] 보너스 숫자와 일치하는 로또 번호가 있습니다.");
    }
}
