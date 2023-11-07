package lotto.exception.Bonus;

public class BonusDuplicationException extends IllegalArgumentException {

    public BonusDuplicationException() {
        super("[ERROR] 로또 당첨 보너스 번호와 로또 당첨 번호는 중복될 수 없습니다.");
    }
}
