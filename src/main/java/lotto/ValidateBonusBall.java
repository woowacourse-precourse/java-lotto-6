package lotto;

public class ValidateBonusBall {

    public void isInRange(int bonusBall) {
        if (bonusBall < 1) {
            throw new IllegalArgumentException("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
        }
        if (bonusBall > 45) {
            throw new IllegalArgumentException("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
        }
    }
}
