package lotto.domain.validation;

import lotto.constants.ErrorMassageConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constants.LottoNumberConstants.*;
import static lotto.constants.NumberOfLottoPurchaseConstants.COMMA;

public class LottoWinningNumberValidation {
    private static List<Integer> lottoWinningNumbers;
    public List<Integer> winningNumberValidation(String winningNumber) {
        lottoWinningNumbers = convertLottoWinningNumber(winningNumber);
        duplicatedWinningNumber();
        allNumbersInRange();
        winningNumberByOverSize();
        return lottoWinningNumbers;
    }

    private List<Integer> convertLottoWinningNumber(String winningNumber) {
        try {
            return Arrays.stream(winningNumber.split(COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMassageConstants.CONVERT_LOTTO_WINNING_NUMBER_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private void duplicatedWinningNumber(){
        Set<Integer> set = new HashSet<>(lottoWinningNumbers);
        if(set.size() != lottoWinningNumbers.size()){
            throw new IllegalArgumentException(ErrorMassageConstants.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    private void allNumbersInRange() {
        for (int number : lottoWinningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMassageConstants.WINNING_NUMBERS_IN_RANGE_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void winningNumberByOverSize() {
        if(lottoWinningNumbers.size() != LOTTO_NUMBER_RANGE){
            throw new IllegalArgumentException(ErrorMassageConstants.WINNING_NUMBER_SIZE_OVER_ERROR_MESSAGE.getMessage());
        }
    }
}
