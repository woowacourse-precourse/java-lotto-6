package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class OutputView {
    private static final String DIGIT_COMMA_WITH_BLANK = ", ";
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void outputLottoNumbers(List<Lotto> lotties) {
        System.out.printf(Message.OUTPUT_COMPLETE_BUY_LOTTO.message, lotties.size());
        for (Lotto lotto : lotties) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.printf(Message.OUTPUT_LOTTO_NUMBERS.message, formatter(numbers));
        }
    }

    private String formatter(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DIGIT_COMMA_WITH_BLANK));
    }

    private enum Message {
        OUTPUT_COMPLETE_BUY_LOTTO("\n%s개를 구매했습니다.\n"),
        OUTPUT_LOTTO_NUMBERS("[%s]\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
