package lotto.view.input.validator;

import lotto.exception.custom.CustomNullPointAmountException;
import lotto.exception.custom.CustomNumberFormatAmountException;
import lotto.exception.winning.BonusExceptionStatus;

public class ReadBonusValidator {

    private static final ReadBonusValidator READ_BONUS_VALIDATOR = new ReadBonusValidator();

    private ReadBonusValidator() {
    }

    public static int validateBonus(final String bonus) {
        return READ_BONUS_VALIDATOR.parseBonus(bonus);
    }

    private int parseBonus(final String bonus) {
        try {
            return Integer.parseInt(isNullBonus(bonus));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(BonusExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullBonus(final String winning) {
        try {
            return winning.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(BonusExceptionStatus.READ_IS_NULL);
        }
    }
}
