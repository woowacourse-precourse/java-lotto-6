package lotto.util.validation;

import lotto.util.ErrorThrower;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.ErrorMessage.BONUS_DISTINCT_WINNING_NUMBER_ERROR;
import static lotto.config.ErrorMessage.BONUS_EXCEED_RANGE_ERROR;
import static lotto.config.ErrorMessage.BONUS_ONLY_NUMBER_ERROR;
import static lotto.config.ErrorMessage.LOTTO_DISTINCT_ERROR;
import static lotto.config.ErrorMessage.LOTTO_EXCEED_RANGE_ERROR;
import static lotto.config.ErrorMessage.WINNING_NUMBER_ONLY_NUMBER_ERROR;
import static lotto.config.LottoConfig.LOTTO_COUNT;
import static lotto.config.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.config.LottoConfig.LOTTO_MIN_NUMBER;
import static lotto.config.RegexPattern.LOTTO_WINNING_NUMBER_REGEX_PATTERN;
import static lotto.config.RegexPattern.ONLY_NUMBER_REGEX_PATTERN;

public class LottoValidation {

    public void validatorDuplicatedNumber(List<Integer> lottoNumber) {

        lottoNumber = lottoNumber.stream().distinct().collect(Collectors.toList());

        if (lottoNumber.size() != LOTTO_COUNT.getValue()) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_DISTINCT_ERROR.getMessage());
        }

    }

    public void validatorExceededRange(List<Integer> lottoNumber) {

        for (int number : lottoNumber) {
            if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
                ErrorThrower.throwIllegalArgumentException(LOTTO_EXCEED_RANGE_ERROR.getMessage());
            }
        }

    }

    public void validatorWinningNumberCheck(String winningNumber) {

        if (!winningNumber.matches(LOTTO_WINNING_NUMBER_REGEX_PATTERN.getPattern())) {
            ErrorThrower.throwIllegalArgumentException(WINNING_NUMBER_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorBonusOnlyNumber(String bonus) {

        if (!bonus.matches(ONLY_NUMBER_REGEX_PATTERN.getPattern())) {
            ErrorThrower.throwIllegalArgumentException(BONUS_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorBonusExceedRange(String bonus) {

        int bonusNumber = Integer.parseInt(bonus);

        if (bonusNumber < LOTTO_MIN_NUMBER.getValue() || bonusNumber > LOTTO_MAX_NUMBER.getValue()) {
            ErrorThrower.throwIllegalArgumentException(BONUS_EXCEED_RANGE_ERROR.getMessage());
        }

    }

    public void validatorBonusDistinct(String bonus, List<Integer> winningNumber) {

        int bonusNumber = Integer.parseInt(bonus);

        for (int number : winningNumber) {
            if (number == bonusNumber) {
                ErrorThrower.throwIllegalArgumentException(BONUS_DISTINCT_WINNING_NUMBER_ERROR.getMessage());
            }
        }

    }

}
