package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputData {

    public static String playerFinance() {
        String inputData;
        do {
            inputData = Console.readLine();
            try {
                Validate.checkNumericInput(inputData);
                int amount = Integer.parseInt(inputData);
                Validate.checkMinimumAmount(amount);
                Validate.checkThousandMultiple(amount);
                return inputData;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        } while (true);
    }

    private static List<Integer> parseIntegers(String str) {
        return Stream.of(str.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static List<Integer> winningNumber() {
        List<Integer> winningNumbers;
        do {
            String inputData = Console.readLine();
            try {
                Validate.checkFormat(inputData);
                Validate.checkNumberInRange(inputData);
                Validate.checkValidSixNumberInput(inputData);
                winningNumbers = parseIntegers(inputData);
                return winningNumbers;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        } while (true);
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        do {
            String inputData = Console.readLine();
            try {
                Validate.checkNumericInput(inputData);
                bonusNumber = Integer.parseInt(inputData);
                Validate.checkSingleNumberInRange(bonusNumber);
                Validate.checkBonusNumberUniqueness(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        } while (true);
    }
}
