package lotto.exception.Bonus;

public class BonusNotNumericException extends IllegalArgumentException {

    public BonusNotNumericException() {
        super("[ERROR] 로또 당첨 보너스 번호는 문자가 아니라 숫자이어야 합니다.");
    }
}
