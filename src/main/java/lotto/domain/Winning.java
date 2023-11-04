package lotto.domain;

import java.util.List;

import static lotto.domain.constant.ErrorConst.WINNING_HAS_DUPLICATE;

public class Winning {

    private final Lotto winningNumber;
    private final Bonus bonusNumber;

    public Winning(Lotto winningNumber, Bonus bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, Bonus bonusNumber) {
        List<Integer> winning = winningNumber.getNumbers();
        int bonus = bonusNumber.getBonusNumber();

        if (winning.stream().anyMatch(
                number -> number == bonus
        )) {
            throw new IllegalArgumentException(WINNING_HAS_DUPLICATE);
        }
    }
}
