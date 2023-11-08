package lotto.validator;


import lotto.exception.NotNumberException;

public class NumberValidator {
    public static void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new NotNumberException();
        }
    }
}
