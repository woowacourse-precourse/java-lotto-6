package lotto.view;

import lotto.enums.OutputMessage;

public class OutputView {
    public static void showCountOfLotto(int countOfLotto) {
        String format = OutputMessage.OUTPUT_COUNT_OF_LOTTO_FORMAT.getMessage();

        System.out.println(String.format(format, countOfLotto));
    }
}
