package lotto.controller;
import lotto.view.ErrorMessage;

import java.util.List;
public class ErrorCheck {
    public static void priceErrorCheck(String price) throws IllegalArgumentException {
        int priceInt = Integer.parseInt(price);
        if (priceInt % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.notPriceMessage());
        }
    }

    public static void stringChangeChar(String[] choiceLottoNum) throws IllegalArgumentException {
        for (String s : choiceLottoNum) {
            isDigitErrorCheck(s);
        }
    }

    public static void isDigitErrorCheck(String s) throws IllegalArgumentException {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.notIntegerMessage());
            }
        }
    }

    public static void isDuplicationErrorCheck(String choice, List<Integer> numbers) throws IllegalArgumentException {
        Integer bonusNum = Integer.parseInt(choice);
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorMessage.isDuplication());
        }

    }

    public static void isValidateMaxAndMinNum(String choice) {
        Integer bonusNum = Integer.parseInt(choice);
        if (1 > bonusNum || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessage.isMaxAndMinValue());
        }
    }

    public static void isSpaceValue(String choice) {
        if (choice.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.isSpace());
        }
    }
    public static void stringArrChangeString(String[] choiceLottoNum) throws IllegalArgumentException {
        for (String s : choiceLottoNum) {
            isSpaceValue(s);
        }
    }
}
