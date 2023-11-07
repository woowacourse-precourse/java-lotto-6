package lotto;

import lotto.configuration.Constants;

public class NumberGenerator {

    public int createOne(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.CONVERT_NUMBER_ERROR);
        }
        return number;
    }

}
