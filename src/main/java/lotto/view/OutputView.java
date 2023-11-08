package lotto.view;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
