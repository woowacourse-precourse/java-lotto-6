package lotto.exception.Bonus;

public class BonusNotInRangeException extends IllegalArgumentException {

    public BonusNotInRangeException() {
        super("[ERROR] 로또 당첨 보너스 번호는 1 이상 45 이하의 숫자로 입력해야 합니다.");
    }
}
