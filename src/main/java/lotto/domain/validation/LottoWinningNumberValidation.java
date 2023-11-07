package lotto.domain.validation;

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
        return lottoWinningNumbers;
    }

    private List<Integer> convertLottoWinningNumber(String winningNumber) {
        try {
            return Arrays.stream(winningNumber.split(COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : The provided winning numbers are not valid integers: ", e);
        }
    }

    private void duplicatedWinningNumber(){
        Set<Integer> set = new HashSet<>(lottoWinningNumbers);
        if(set.size() != lottoWinningNumbers.size()){
            throw new IllegalArgumentException("[ERROR] : The provided winning numbers contain duplicates.");
        }
    }

    private void allNumbersInRange() {
        for (int number : lottoWinningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] : Lotto numbers must be in the range of " +
                        MIN_LOTTO_NUMBER + " to " + MAX_LOTTO_NUMBER + ".");
            }
        }
    }
}
