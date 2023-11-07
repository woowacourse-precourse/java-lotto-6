package lotto.exception.Lotto;

public class LottoNotSizeSixException extends IllegalArgumentException {

    public LottoNotSizeSixException() {
        super("[ERROR] 로또 당첨 번호는 6개의 숫자를 입력해야 합니다.");
    }
}
