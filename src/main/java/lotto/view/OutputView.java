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

    public static void inputViewWinningNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.inputMessage());
    }

    public static void inputViewBonusNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.inputMessage());

    }
}
