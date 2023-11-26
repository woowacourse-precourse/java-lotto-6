package lotto.domain.lotto.validator;

import java.util.List;
import lotto.domain.ball.Ball;
import lotto.exception.custom.CustomIllegalArgumentException;
import lotto.exception.winning.BonusExceptionStatus;

public class WinningValidator {

    private static final WinningValidator WINNING_VALIDATOR = new WinningValidator();

    private WinningValidator(){
    }

    public static void validateWinning(final List<Ball> lotto, final Ball bonus) {
        WINNING_VALIDATOR.validateWinningIsDuplicated(lotto, bonus);
    }

    private void validateWinningIsDuplicated(final List<Ball> lotto, final Ball bonus) {
        if (isDuplicated(lotto, bonus)) {
            throw new CustomIllegalArgumentException(BonusExceptionStatus.BONUS_IS_DUPLICATED);
        }
    }

    private boolean isDuplicated(final List<Ball> lotto, final Ball bonus) {
        return lotto.contains(bonus);
    }
}
