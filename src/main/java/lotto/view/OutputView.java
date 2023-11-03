package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void outputLottoNumbers(List<Lotto> lotties) {
        System.out.printf(Message.OUTPUT_COMPLETE_BUY_LOTTO.message, lotties.size());
        for (Lotto lotto : lotties) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.printf(Message.OUTPUT_LOTTO_NUMBERS.message,
                    numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));
        }
    }

    private enum Message {
        OUTPUT_COMPLETE_BUY_LOTTO("\n%s개를 구매했습니다.\n"),
        OUTPUT_LOTTO_NUMBERS("[%d, %d, %d, %d, %d, %d]\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
