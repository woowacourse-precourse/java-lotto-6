package lotto.exception.game;

public class OverlapBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되는 번호는 입력할 수 없습니다.";

    public OverlapBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
