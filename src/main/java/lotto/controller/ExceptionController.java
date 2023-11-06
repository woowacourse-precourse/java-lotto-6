package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Number;
import lotto.model.Price;

import java.util.List;

import static lotto.controller.InputConverter.convertPrice;
import static lotto.view.ErrorMessage.*;

public class ExceptionController {

    public static Price checkPriceException(String inputPrice) throws IllegalArgumentException{
        try {
            int price = checkDigitException(inputPrice);
            return checkRightPrice(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static Price checkRightPrice(int price) throws IllegalArgumentException{
        try {
            return new Price(price);
        } catch (IllegalArgumentException e) {
            priceZeroException();
            throw new IllegalArgumentException();
        }
    }


    public static BonusNumber checkBonusNumberException(List<Integer> numbers, String tmpBonus) throws IllegalArgumentException {
        try {
            int bonus = checkDigitException(tmpBonus);
            checkNumberException(bonus);
            checkDuplicateException(numbers, bonus);
            return new BonusNumber(bonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int checkDigitException(String inputNum) throws IllegalArgumentException {
        try {
            return convertPrice(inputNum);
        } catch (IllegalArgumentException e) {
            notDigitExceptionMessage();
            throw new IllegalArgumentException();
        }
    }
    public static void checkNumberException(int num) throws IllegalArgumentException {
        try {
            Number.checkRange(num);
        } catch (IllegalArgumentException e) {
            outOfBoundExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        try {
            Number.checkDuplicate(numbers, bonus);
        } catch (IllegalArgumentException e) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }
}
