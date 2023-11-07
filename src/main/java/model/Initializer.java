package model;

import constants.Constants;
import exception.DuplicateBonusNumberException;
import exception.InvalidWinningLottoFormatException;
import exception.NonNumericBonusNumberException;
import exception.OutOfLottoNumberRangeException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Lotto;

public class Initializer {

    public Lotto initWinningLotto(String userInput) {
        validateFormat(userInput);
        List<Integer> winningNumbers = convertToList(userInput);
        return new Lotto(winningNumbers);
    }

    public int initBonusNumber(String userInput, Lotto winningLotto) {
        validateInt(userInput);
        validateRange(userInput);
        int bonusNum = Integer.parseInt(userInput);
        validateNoDuplicates(bonusNum, winningLotto);
        return bonusNum;
    }

    private void validateFormat(String userInput) {
        String regex = "^([0-9],){" + (Constants.LOTTO_LENGTH - 1) + "}[0-9]$";
        if (!Pattern.matches(userInput, regex)) {
            throw new InvalidWinningLottoFormatException();
        }
    }

    private List<Integer> convertToList(String userInput) {
        return Arrays.stream(userInput.split(Constants.DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateInt(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NonNumericBonusNumberException();
        }
    }

    private void validateRange(String userInput) {
        int bonusNum = Integer.parseInt(userInput);
        if (bonusNum < Constants.LOTTO_RANGE_START || bonusNum > Constants.LOTTO_RANGE_END) {
            throw new OutOfLottoNumberRangeException();
        }
    }

    private void validateNoDuplicates(int bonusNum, Lotto winningLotto) {
        boolean isDuplicate = winningLotto.getNumbers().contains(bonusNum);
        if(isDuplicate){
            throw new DuplicateBonusNumberException();
        }
    }
}