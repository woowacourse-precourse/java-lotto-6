package lotto;

public class WiningLotto {
    private final Lotto winNumber;
    private final int bonus;


    public WiningLotto(Lotto winNumber, int bonus) {
        validate(winNumber, bonus);
        this.winNumber = winNumber;
        this.bonus = bonus;
    }

    private void validate(Lotto winNumber, int bonus) {
        validateRange(winNumber, bonus);
        validateBonusDuplication(winNumber, bonus);
    }

    public void validateRange(Lotto winNumber, int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력하세요");
        }
    }

    public void validateBonusDuplication(Lotto winNumber, int bonus) {
        if (winNumber.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다.");
        }
    }


}
