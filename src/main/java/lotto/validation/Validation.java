package lotto.validation;

import lotto.Model.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Validation {
    public static Integer userInputMoneyCheck(String userInput) {
        try {
            isNumber(userInput);
            isMoneyMatch(Integer.parseInt(userInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
        return Integer.parseInt(userInput);
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_DATAFORMAT.getErrorMessage());
        }
    }
    public static void isCheckEmpty(String input){
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY.getErrorMessage());
        }
    }
    public static void isOnlyComma(final String input) {
        if (input.matches("^,.*") || input.matches(".*,$")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }

    public static void isStringToInt(final String input) {
        try {
            for (String number : input.split(",")) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_DATAFORMAT.getErrorMessage());
        }
    }


    private static void isMoneyMatch(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_RANGE.getErrorMessage());
        }
    }

    private static void isMultipleOfThousand(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage());
        }
    }
    private static void isNumberRangeCheck(List<Integer> numbers){
        for(int number : numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException((ErrorMessage.ERROR_BONUS_RANGE.getErrorMessage()));
            }
        }
    }


    private static void isDuplicateBonusNumber(List<Integer> winNumber, int bonus) {
        if (winNumber.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage() + ErrorMessage.ERROR_BONUS_DUPLICATION);
        }
    }

//    public static List<Integer> winNumberCheck(String userInput) {
//
//        String[] numbers = userInput.split(",");
//
//        try {
//            validateWinNumberInput(userInput);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e);
//            return Collections.emptyList();
//        }
//        return Arrays.stream(numbers)
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toList());
//    }

//    public static void validateWinNumberInput(String input) {
//        String[] split = input.split(",");
//
//        if (split.length != 6) {
//            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
//        }
//
//        for (String str : split) {
//            isNumber(str);
//        }
//
//        for (String s : split) {
//            int num = Integer.parseInt(s);
//            isNumberInBoundary(1, 45, num);
//        }
//    }


}
