package lotto.util;

import com.sun.jdi.InvalidTypeException;
import lotto.enumeration.ExceptionType;
import lotto.enumeration.NoticeType;

import java.util.InputMismatchException;

public class Validator {
    public static boolean validateAmount(String input) {
        if(validateAmountType(input) &&
                validateAmountRange(Integer.parseInt(input)) &&
                validateAmountMultiple(Integer.parseInt(input))) {
            return true;
        }
        return false;
    }
    public static boolean validateAmountType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            System.out.println(ExceptionType.INVALID_AMOUNT_TYPE.getMessage());
            return false;
        }
    }

    public static boolean validateAmountRange(int input) {
        try {
            if (input > 2000000000 || input < 1000) { // limit 상수처리
                throw new InputMismatchException(ExceptionType.EXCEED_AMOUNT_LIMIT.getMessage());
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateAmountMultiple(int amount) {
        try {
            if(amount / 1000 != 0) {
                throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_MULTIPLE_1000.getMessage());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
