package view;

import util.OutputMessage;

import java.util.List;

public class OutputView {

    public static void printNumOfLotto(int number) {
        System.out.println(number+ OutputMessage.SHOW_AMOUNT_OF_LOTTO.getOutputMessage());
    }

    public static void printLottoTickets(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
