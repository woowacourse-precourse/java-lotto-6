package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

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
