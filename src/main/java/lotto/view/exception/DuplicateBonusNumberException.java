package lotto.view.exception;


public class DuplicateBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복";

    public DuplicateBonusNumberException() {
        super(ERROR_MESSAGE);
    }

}
