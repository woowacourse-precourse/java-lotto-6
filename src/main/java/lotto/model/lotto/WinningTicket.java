package lotto.model.lotto;

import lotto.common.exception.ErrorMessage;

public record WinningTicket(Lotto lotto, BonusBall bonusBall) {
    public WinningTicket {
        validateDuplicate(lotto, bonusBall);
    }

    private void validateDuplicate(Lotto lotto, BonusBall bonusBall) {
        if (lotto.contains(bonusBall.number())) {
            throw new IllegalStateException(
                    ErrorMessage.DUPLICATED_WINNING_LOTTO_NUMBER_AND_BONUS_BALL.getValue(lotto, bonusBall));
        }
    }
}
