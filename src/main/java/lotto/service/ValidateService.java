package lotto.service;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.*;
import static lotto.constant.ErrorMessage.*;
public class ValidateService {
    public int validateBuyLottoInput(String buyPriceInput) {
        int buyPrice = parseIntPrice(buyPriceInput);
        isMultipliesOf1000(buyPrice);
        return buyPrice;
    }
    public List<Integer> createWinNumbers(String winNumbersInput) {
        List<Integer> numbers = new ArrayList<>();
        String[] winNumbers = winNumbersInput.split(",");

        for (String winNumber : winNumbers) {
            int number = validateWinNumber(winNumber);
            numbers.add(number);
        }

        validateWinNumbers(numbers);
        return numbers;
    }

    private void validateWinNumbers(List<Integer> numbers) {
        isSize6(numbers);
        isDuplicates(numbers);
    }

    private void isSize6(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(ERROR_WIN_NUMBERS_SIZE_IS_NOT_6);
        }
    }

    private void isDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ERROR_WIN_NUMBERS_DUPLICATES);
        }
    }

    private int validateWinNumber(String winNumber) {
        int number = parseIntWinNumber(winNumber);
        isBetween1to45(number);
        return number;
    }

    private void isMultipliesOf1000(int buyPrice) {
        if (buyPrice % LOTTO_PRICE_FOR_ONE != 0) {
            throw new IllegalArgumentException(ERROR_BUY_PRICE_IS_NOT_MULTIPLE_Of_1000);
        }
    }

    private void isBetween1to45(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_WIN_NUMBER_IS_NOT_BETWEEN_1_45);
        }
    }

    private int parseIntPrice(String buyPriceInput) {
        return parseInt(buyPriceInput, ERROR_BUY_PRICE_IS_NOT_INTEGER);
    }

    private int parseIntWinNumber(String winNumber) {
        return parseInt(winNumber, ERROR_WIN_NUMBER_IS_NOT_INTEGER);
    }

    private int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
