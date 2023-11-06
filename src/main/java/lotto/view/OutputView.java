package lotto.view;

import lotto.configuration.InputMessage;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static void lottoNumbersResult(List<Integer> lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Integer number : lotto) {
            joiner.add(number.toString());
        }
        System.out.println(joiner.toString());
    }

    public static void inputWinningNumber() {
        System.out.println();
        InputMessage.INPUT_WINNING_NUMBERS.inputMessage();
    }
}
