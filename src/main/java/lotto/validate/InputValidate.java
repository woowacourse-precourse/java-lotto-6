package lotto.validate;

import lotto.errormessage.InputError;

public class InputValidate {
    public static void validateIsNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < 48 || number.charAt(i) > 57) {
                throw new IllegalArgumentException(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public static void validateIsDivideThousand(String number){
        int num = Integer.parseInt(number);
        if(num%1000!=0) throw new IllegalArgumentException(InputError.INPUT_NOT_DIVIDE_THOUSAND_ERROR_MESSAGE);
    }
}
