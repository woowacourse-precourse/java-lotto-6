package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static Integer inputPurchaseAmount() {
        System.out.println(MessageConstants.PURCHASE_AMOUNT_GUIDE);
        String inputValue = Console.readLine();
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(MessageConstants.WINNING_NUMBERS_GUIDE);
        String[] inputValues = Console.readLine().split(",");
        List<Integer> inputIntValues = parseStringToInteger(inputValues);
        return inputIntValues;
    }

    private static List<Integer> parseStringToInteger(String[] inputValues) {
        List<Integer> inputIntValues = Arrays.stream(inputValues).map(v -> Integer.parseInt(v)).collect(Collectors.toList());
        return inputIntValues;
    }

    public static Integer inputBonusNumber() {
        System.out.println(MessageConstants.BONUS_NUMBER_GUIDE);
        Integer inputValue = Integer.parseInt(Console.readLine());
        return inputValue;
    }
}
