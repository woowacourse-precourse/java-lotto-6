package lotto.exception;

public class BonusNumberDuplicatedException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 당첨 번호에 보너스 번호와 중복된 숫자가 있습니다!";
    public BonusNumberDuplicatedException() {
        super(MESSAGE);
    }
}
