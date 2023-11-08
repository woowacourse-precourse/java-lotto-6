package lotto.exception;

public class MissingBonusNumberException extends IllegalArgumentException {
    public MissingBonusNumberException() {
        super("[ERROR] 보너스 번호는 공백일 수 없습니다.");
    }
}
