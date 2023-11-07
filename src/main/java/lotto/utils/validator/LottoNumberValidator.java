package lotto.utils.validator;

import static lotto.constant.ExceptionMessage.NO_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.OUT_OF_RANGE_ERROR_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.HashSet;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

public class LottoNumberValidator {

    public static void validateDuplicateNumbers(List<Integer> lottoNumbers) {
        if (isDuplicateNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateOutOfRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateOutOfRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicate(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if (bonusNumber.hasBonus(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean isDuplicateNumbers(List<Integer> winningNumber) {
        return new HashSet<>(winningNumber).size() < LOTTO_LENGTH;
    }

    private static boolean isOutOfRange(int number) {
        return MAX_NUMBER < number || number < MIN_NUMBER;
    }
}
