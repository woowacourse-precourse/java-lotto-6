package lotto.exception.InputView;

public class InputLottoSeparateRegexException extends IllegalArgumentException {

    public InputLottoSeparateRegexException() {
        super("[ERROR] 로또 당첨 번호를 구분하기 위해 쉼표(,)만 사용해야 합니다.");
    }
}
