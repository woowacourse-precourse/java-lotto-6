package lotto.domain;

import static lotto.constants.ErrorMessages.DUPLICATES;
import static lotto.constants.ErrorMessages.DUPLICATES_BONUS_NUMBERS;
import static lotto.constants.ErrorMessages.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessages.LOTTO_NUMBERS;
import static lotto.constants.ErrorMessages.THOUSANDS;
import static lotto.constants.ErrorMessages.WRONG_FORMAT;
import static lotto.constants.PromptMessages.BONUS_NUMBER;
import static lotto.constants.PromptMessages.PURCHASE_AMOUNT;
import static lotto.constants.PromptMessages.WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputChecker {
    static int readLottoPrice() {
        while (true) {
            try {
                String price_string = getPurchaseAmountInput();
                checkIfNumeric(price_string);
                int price = Integer.parseInt(price_string);
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException(THOUSANDS.getErrorMessage());
                }
                return price;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        List<Integer> winningNumbers = null;

        while (winningNumbers == null) {
            try {
                String input = getWinningNumberInput();
                winningNumbers = processInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private String getWinningNumberInput() {
        System.out.println(WINNING_NUMBERS.getPromptMessage());
        return Console.readLine();
    }
    private static String getPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT.getPromptMessage());
        String price_string = Console.readLine();
        return price_string;
    }

    private List<Integer> processInput(String input) {
        validateLottoNumbers(input);

        String[] numberStrings = input.split(",");
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateLottoNumbers(String input) {
        String[] numberStrings = input.split(",");
        if(numberStrings.length!=6) throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getErrorMessage());
        Set<Integer> distinctNumbers = new HashSet<>();

        for (String numberString : numberStrings) {
            checkIfNumeric(numberString);

            int number = Integer.parseInt(numberString);
            validateLottoRange(number);
            validateNoDuplicates(distinctNumbers, number);
        }
    }

    private static void checkIfNumeric(String numberString) {
        if (!numberString.matches("\\d+")) {
            throw new IllegalArgumentException(WRONG_FORMAT.getErrorMessage());
        }
    }

    private static void validateLottoRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBERS.getErrorMessage());
        }
    }

    private static void validateNoDuplicates(Set<Integer> distinctNumbers, int number) {
        if (!distinctNumbers.add(number)) {
            throw new IllegalArgumentException(DUPLICATES.getErrorMessage());
        }
    }

    static Integer readBonusNumber(List<Integer> winningNumbers) {
        Integer bonusNumber;
        while (true){
            try{
                System.out.println(BONUS_NUMBER.getPromptMessage());
                bonusNumber = Integer.parseInt(Console.readLine());

                if(winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException(DUPLICATES_BONUS_NUMBERS.getErrorMessage());
                }
                return bonusNumber;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
