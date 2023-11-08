package lotto.exception;

public class DuplicateTierConditionException extends IllegalStateException {
    public DuplicateTierConditionException() {
        super("당첨을 위한 조건이 중복되었습니다. 코드를 확인해주세요.");
    }
}
