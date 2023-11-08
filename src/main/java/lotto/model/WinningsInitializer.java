package lotto.model;

import lotto.constants.Constants;
import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.InvalidWinningLottoFormatException;
import lotto.exception.NonNumericBonusNumberException;
import lotto.exception.OutOfLottoNumberRangeException;
import java.util.Arrays;
import java.util.List;

public class WinningsInitializer {

    public Lotto initWinningLotto(String userInput) throws IllegalArgumentException {
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
        String regex = "^\\d+(,\\d+){" + (Constants.LOTTO_LENGTH - 1) + "}$";
        if (!userInput.matches(regex)) {
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
        if (isDuplicate) {
            throw new DuplicateBonusNumberException();
        }
    }
}