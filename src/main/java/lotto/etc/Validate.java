package lotto.etc;

import static lotto.etc.ErrorConstant.NOT_NUMBER_ERROR;

public class Validate {

    public static int validateNumber(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println(NOT_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
