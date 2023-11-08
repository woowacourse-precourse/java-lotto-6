package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int requestPurchaseAmount() {
        printConstantMessage(ConstantMessage.REQUEST_PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> requestWinningNumbers() {
        printConstantMessage(ConstantMessage.REQUEST_WINNING_NUMBERS);
        return parseNumbers(Console.readLine());
    }

    public static int requestBonusNumber() {
        printConstantMessage(ConstantMessage.REQUEST_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static <T> void printListWithNewLine(List<T> messages) {
        messages.forEach(System.out::println);
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
