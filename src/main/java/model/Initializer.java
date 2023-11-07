package model;

import constants.Constants;
import exception.InvalidWinningLottoFormatException;
import java.util.regex.Pattern;

public class Initializer {

    private void validateFormat(String userInput) {
        String regex = "^([0-9],){" + (Constants.LOTTO_LENGTH - 1) + "}[0-9]$";
        if (!Pattern.matches(userInput, regex)) {
            throw new InvalidWinningLottoFormatException();
        }
    }
}