package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto answerLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(int bonusNumber) {
        validateCorrectRange(bonusNumber);
        validateDuplicateNumber(bonusNumber);
    }

    private void validateDuplicateNumber(int bonusNumber) {
        if (answerLotto.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 보너스 숫자는 당첨 번호와 중복될 수 없습니다");
        }
    }

    private void validateCorrectRange(int bonusNumber) {
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 1에서 45 사이의 범위를 벗어납니다.");
        }
    }

}
