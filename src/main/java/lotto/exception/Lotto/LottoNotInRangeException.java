package lotto.exception.Lotto;

public class LottoNotInRangeException extends IllegalArgumentException {

    public LottoNotInRangeException() {
        super("[ERROR] 로또 당첨 번호는 1 이상 45 이하의 숫자이어야 합니다.");
    }
}
