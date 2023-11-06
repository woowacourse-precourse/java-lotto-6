package lotto.view;

import static lotto.constant.message.OutputMessage.BONUS_RESULT;
import static lotto.constant.message.OutputMessage.PRIZE_RESULT;
import static lotto.constant.message.OutputMessage.PROFIT_RATE;
import static lotto.constant.message.OutputMessage.PURCHASE_COUNT_RESULT;
import static lotto.constant.message.OutputMessage.RESULT_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.constant.Prize;
import lotto.domain.Lotto;

public class OutputView {
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> tickets) {
        String message = String.format(PURCHASE_COUNT_RESULT, tickets.size());
        System.out.println(message);
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printPrizeResult(Map<Prize, Integer> result) {
        for (Map.Entry<Prize, Integer> pair : result.entrySet()) {
            String message = String.format(PRIZE_RESULT,
                    pair.getKey().getMatch(), pair.getKey().getPanel(), pair.getValue());
            if (pair.getKey().equals(Prize.SECOND)) {
                message = String.format(BONUS_RESULT,
                        pair.getKey().getPanel(), pair.getValue());
            }
            if (pair.getKey().equals(Prize.NONE)) {
                return;
            }
            System.out.println(message);
        }
    }

    public void printProfitRate(String profitRate) {
        String message = String.format(PROFIT_RATE, profitRate);
        System.out.println(message);
    }
}
