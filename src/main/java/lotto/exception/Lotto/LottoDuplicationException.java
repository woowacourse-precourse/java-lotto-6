package lotto.exception.Lotto;

public class LottoDuplicationException extends IllegalArgumentException {

    public LottoDuplicationException() {
        super("[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");
    }
}
