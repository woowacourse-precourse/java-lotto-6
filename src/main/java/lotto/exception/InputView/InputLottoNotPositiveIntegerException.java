package lotto.exception.InputView;

public class InputLottoNotPositiveIntegerException extends IllegalArgumentException {

    public InputLottoNotPositiveIntegerException() {
        super("[ERROR] 로또 당첨 번호는 문자가 아니라 숫자이어야 합니다.");
    }
}
