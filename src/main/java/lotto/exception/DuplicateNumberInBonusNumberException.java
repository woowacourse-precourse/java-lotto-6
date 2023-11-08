package lotto.exception;

public class DuplicateNumberInBonusNumberException extends LottoException{
    private static final String ERROR_MESSAGE = "보너스 넘버가 일반 번호와 중복됩니다.";

    public DuplicateNumberInBonusNumberException() {
        super(ERROR_MESSAGE);
    }

}
