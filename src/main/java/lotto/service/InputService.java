package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PriceValidator;

public class InputService {

    public boolean priceValidate(String input) {
        try {
            PriceValidator.isNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        int price = Integer.parseInt(input);
        try {
            PriceValidator.isMultipleOfThousand(price);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
            return false;
        }
        try {
            PriceValidator.isPositive(price);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    public boolean lottoValidate(List<String> list) {
        try {
            LottoValidator.isAllNumeric(list);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        return true;
    }

    public boolean bonusNumberValidate(String input, List<Integer> winNumber) {
        try {
            BonusNumberValidator.isNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        try {
            BonusNumberValidator.haveValidateRange(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_RANGE.getMessage());
            return false;
        }
        try {
            BonusNumberValidator.haveDuplicateNumber(winNumber, input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.HAVE_DUPLICATE_BONUS_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    public List<String> stringToList(String input) {
        return Arrays.stream(input.replace(" ", "").split(",")).toList();
    }

    public List<Integer> stringListToIntegerList(List<String> stringList) {
        return stringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }
}
