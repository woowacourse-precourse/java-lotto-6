package lotto.etc;

import static lotto.etc.ErrorConstant.BETWEEN_ONE_AND_FORTY_FIVE_ERROR;
import static lotto.etc.ErrorConstant.NOT_NUMBER_ERROR;

public class Validate {

    public static int validateNumber(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.toString());
        }
    }

    public static void checkOneAndFortyFive(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(BETWEEN_ONE_AND_FORTY_FIVE_ERROR.toString());
        }
    }


}
