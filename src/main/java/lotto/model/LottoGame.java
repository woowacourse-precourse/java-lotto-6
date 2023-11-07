package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class LottoGame {
    public static int attemptToGetPurchaseAmount() {
        String input = Console.readLine().trim();
        Validator.validatePurchaseInput(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> convertInputToIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public static int attemptToGetBonusNumber(List<Integer> winningNumbers){
        String input = Console.readLine().trim();
        Validator.isPositiveInteger(input);
        Validator.validateBonusNumber(Integer.parseInt(input), winningNumbers);
        return Integer.parseInt(input);
    }


    public static List<Integer> attempToGetWinningNumbers() {
        String input = Console.readLine().trim();
        Validator.validateWinningNumbers(input);
        return convertInputToIntegerList(input);


//        if (!input.matches("(\\d+,){5}\\d+")) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.name());
//        }

//        String[] numberStrings = input.split(",");
//        if (numberStrings.length != 6) {
//            throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMBER_COUNT.name());
//        }

//        Set<Integer> numbers = new HashSet<>();
//        for (String numberString : numberStrings) {
//            int number = Integer.parseInt(numberString);
//            validateWinningNumber(number);
//            if (!numbers.add(number)) {
//                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.name());
//            }
//        }
//        return numbers;
//    }
    }
}
