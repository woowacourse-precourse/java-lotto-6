package lotto.view;

import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    private static final String SPACING = " ";
    private static final String EMPTY = "";
    private static final String NUMBER_CHECK_REGEX = "\\d*";
    private static final Integer PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer LOTTO_SIZE = 6;

    public static int getPurchasePrice() {
        try {
            String input = removeInputSpaces();

            emptyValueCheck(input);

            int price = numberCheck(input);

            priceUnitCheck(price);

            return price;

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return getPurchasePrice();
        }
    }

    private static String removeInputSpaces() {
        return readLine().replaceAll(SPACING, EMPTY);
    }

    private static void emptyValueCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_VALUE.getMessage());
        }
    }

    private static int numberCheck(String input) {

        if (!input.matches(NUMBER_CHECK_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage());
        }

        return Integer.parseInt(input);
    }

    private static void priceUnitCheck(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.INCORRECT_UNIT.getMessage());
        }
    }


    public static List<Integer> getWinLottoNumbers() {
        try {
            String input = removeInputSpaces();

            emptyValueCheck(input);

            List<Integer> numbers = new ArrayList<>();
            for (String temp : input.split(SEPARATOR)) {

                int number = numberCheck(temp);

                duplicateCheck(numbers, number);

                numbers.add(number);

            }

            numbersRangeCheck(numbers);

            lottoSizeCheck(numbers);

            return numbers;

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return getWinLottoNumbers();
        }
    }

    private static void numbersRangeCheck(List<Integer> numbers) {
        for(int number : numbers)
            rangeCheck(number);
    }

    private static void rangeCheck(int number) {
        if(number > END_NUMBER || number < START_NUMBER) throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    private static void duplicateCheck(List<Integer> numbers, int number) {
        if(numbers.contains(number)) throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }

    private static void lottoSizeCheck(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE) throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
    }


    public static int getBonusNumber(List<Integer> winLotto) {
        try {
            String input = removeInputSpaces();

            emptyValueCheck(input);

            int bonusNumber = numberCheck(input);

            validateBonusNumber(bonusNumber);

            duplicateBonusNumber(winLotto, bonusNumber);

            return bonusNumber;

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return getBonusNumber(winLotto);
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber > END_NUMBER || bonusNumber < START_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static void duplicateBonusNumber(List<Integer> winLotto, int bonusNumber) {
        if(winLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

}
