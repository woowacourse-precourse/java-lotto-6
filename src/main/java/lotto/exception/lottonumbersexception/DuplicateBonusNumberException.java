package lotto.exception.lottonumbersexception;

public class DuplicateBonusNumberException extends LottoNumbersInputException {
    public DuplicateBonusNumberException() {
        super("[ERROR] 숫자 사이에 ,를 넣어주세요");
    }
}
