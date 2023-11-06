package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.List;

import static lotto.util.Constant.*;

/**
 *
 * @param winningNumbers
 * @param bonusNumber
 */
public record WinningNumbers(Lotto winningNumbers, int bonusNumber) {

    public static int validateBonusNumber(Lotto lotto, String number) {
        validateNumbersType(number);
        int bonusNumber = Integer.parseInt(number);
        validateBonusNumberInWinningNumbers(lotto, bonusNumber);
        validateNumberOutOfRange(bonusNumber);
        return bonusNumber;
    }

    public static void validateNumbersType(String number){
        if (!number.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(ErrorMessage.LOTTO_MUST_CONSIST_OF_NUMBERS);
        }
    }

    public static void validateBonusNumberInWinningNumbers(Lotto lotto, int bonusNumber){
        List<Integer> lottoNumbers = lotto.getLotto();
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ALREADY_IN_WINNING_ERROR);
        }
    }

    public static void validateNumberOutOfRange(int lottoNumber) {
        if(lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

}
