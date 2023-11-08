package lotto;

import java.util.List;

public class WiningLotto {
    private final Lotto winNumber;
    private final int bonus;


    public WiningLotto(Lotto winNumber, int bonus) {
        validate(winNumber, bonus);
        this.winNumber = winNumber;
        this.bonus = bonus;
    }

    private void validate(Lotto winNumber, int bonus) {
        validateRange(bonus);
        validateBonusDuplication(winNumber, bonus);
    }

    private void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력하세요");
        }
    }

    private void validateBonusDuplication(Lotto winNumber, int bonus) {
        if (winNumber.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> showWinNumber() {
        return winNumber.getNumbers();
    }


}
