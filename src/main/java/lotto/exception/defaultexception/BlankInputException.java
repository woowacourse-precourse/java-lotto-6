package lotto.exception.defaultexception;

public class BlankInputException extends LottoDefaultException {
    public BlankInputException() {
        super("[ERROR] 입력값이 비어있습니다.");
    }
}
