package lotto.view;

import static lotto.constant.message.OutputMessage.PURCHASE_COUNT_RESULT;
import static lotto.constant.message.OutputMessage.RESULT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printLottoCount(int count) {
        String message = String.format(PURCHASE_COUNT_RESULT, count);
        
        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
