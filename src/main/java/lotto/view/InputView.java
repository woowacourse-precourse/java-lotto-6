package lotto.view;

import static lotto.exception.ErrorMessage.NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class InputView {

    public static int requestPurchaseAmount() {
        printConstantMessage(ConstantMessage.REQUEST_PURCHASE_AMOUNT);

        // 입력값이 숫자가 아니라면 예외 처리
        if (!Console.readLine().matches("[0-9]+")) {
            throw LottoException.of(NOT_NUMBER);
        }

        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> requestWinningNumbers() {
        printConstantMessage(ConstantMessage.REQUEST_WINNING_NUMBERS);
        return parseNumbers(Console.readLine());
    }

    public static int requestBonusNumber() {
        printNewLine();
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
