package lotto.execption;

public class DuplicateBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 보너스 번호를 입력하였습니다.";

    public DuplicateBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
