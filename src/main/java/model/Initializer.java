package model;

import constants.Constants;
import exception.InvalidWinningLottoFormatException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Lotto;

public class Initializer {
    public Lotto initWinningLotto(String userInput){
        validateFormat(userInput);
        List<Integer> winningNumbers = convertToList(userInput);
        return new Lotto(winningNumbers);
    }

    private void validateFormat(String userInput) {
        String regex = "^([0-9],){" + (Constants.LOTTO_LENGTH - 1) + "}[0-9]$";
        if (!Pattern.matches(userInput, regex)) {
            throw new InvalidWinningLottoFormatException();
        }
    }

    private List<Integer> convertToList(String userInput){
        return Arrays.stream(userInput.split(Constants.DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}