package lotto.Input;

public class LottoBonusNumberException {
    private final Integer bonus;
    public LottoBonusNumberException(Integer bonus) {
        validate(bonus);
        this.bonus = bonus;
    }
    public void validate(Integer bonus) {
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }
}
