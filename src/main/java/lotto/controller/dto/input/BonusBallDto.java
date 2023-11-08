package lotto.controller.dto.input;

import lotto.common.constants.LottoRule;
import lotto.util.InputValidator;
import lotto.util.Parser;

public record BonusBallDto(String bonusBall) {
    private static final int BONUS_BALL_MIN_LENGTH = 1;
    private static final int BONUS_BALL_MAX_LENGTH = String.valueOf(
            LottoRule.LOTTO_NUMBER_MAX.value).length();

    public BonusBallDto {
        InputValidator.validateLength(bonusBall, BONUS_BALL_MIN_LENGTH, BONUS_BALL_MAX_LENGTH);
        InputValidator.validateHasText(bonusBall);
        InputValidator.validateNumeric(bonusBall);
    }

    public int toInt() {
        return Parser.toInt(bonusBall);
    }
}
