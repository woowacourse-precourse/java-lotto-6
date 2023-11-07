package lotto.domain;

import static lotto.constants.ErrorMessages.DUPLICATES;
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
            System.out.println(PURCHASE_AMOUNT.getPromptMessage());
            try {
                int price = Integer.parseInt(Console.readLine());
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException(THOUSANDS.getErrorMessage());
                }
                return price;
            } catch (NumberFormatException e) {
                System.out.println(WRONG_FORMAT.getErrorMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBERS.getPromptMessage());
        String input = Console.readLine();

        validateLottoNumbers(input);

        String[] numberStrings = input.split(",");

        List<Integer> winningNumbers = Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private static void validateLottoNumbers(String input) {
        String[] numberStrings = input.split(",");
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

    static Integer readBonusNumber() {
        Integer bonusNumber;
        while (true){
            try{
                System.out.println(BONUS_NUMBER.getPromptMessage());
                bonusNumber = Integer.parseInt(Console.readLine());
                return bonusNumber;
            }catch (NumberFormatException e) {
                System.out.println(WRONG_FORMAT.getErrorMessage());
            }
        }
    }

}
