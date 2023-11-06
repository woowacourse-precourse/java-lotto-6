package lotto.util.validation;

import lotto.util.ErrorThrower;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.ErrorMessage.*;

public class LottoValidation {

    public void validatorDuplicatedNumber(List<Integer> lottoNumber) {

        lottoNumber = lottoNumber.stream().distinct().collect(Collectors.toList());

        if (lottoNumber.size() != 6) {
            ErrorThrower.throwIllegalArgumentException(LOTTO_DISTINCT_ERROR.getMessage());
        }

    }

    public void validatorExceededRange(List<Integer> lottoNumber) {

        for (int number : lottoNumber) {
            if (number < 1 || number > 45) {
                ErrorThrower.throwIllegalArgumentException(LOTTO_EXCEED_RANGE_ERROR.getMessage());
            }
        }

    }

    public void validatorWinningNumberCheck(String winningNumber) {

        if (!winningNumber.matches("^([0-9]+(,[0-9]+)+)$")) {
            ErrorThrower.throwIllegalArgumentException(WINNING_NUMBER_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorBonusOnlyNumber(String bonus) {

        if (!bonus.matches("[0-9]+")) {
            ErrorThrower.throwIllegalArgumentException(BONUS_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorBonusExceedRange(String bonus) {

        int bonusNumber = Integer.parseInt(bonus);

        if (bonusNumber < 1 || bonusNumber > 45) {
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
