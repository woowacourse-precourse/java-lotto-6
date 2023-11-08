package lotto.exception.InputView;

public class InputBonusNotPositiveIntegerException extends IllegalArgumentException {

    public InputBonusNotPositiveIntegerException() {
        super("[ERROR] 로또 당첨 보너스 번호는 양의 정수로 입력해야 합니다.");
    }
}
