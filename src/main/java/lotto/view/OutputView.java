package lotto.view;

import static lotto.constant.message.OutputMessage.PROFIT_RATE;
import static lotto.constant.message.OutputMessage.PURCHASE_COUNT_RESULT;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    public void printOutputMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> tickets) {
        String message = String.format(PURCHASE_COUNT_RESULT, tickets.size());
        System.out.println(message);
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printPrizeResult(Map<Prize, Integer> res) {
        for (Map.Entry<Prize, Integer> pair : res.entrySet()) {
            if (pair.getKey() != Prize.NONE) {
                System.out.println(prizeResult(pair.getKey()) + pair.getValue() + "개");
            }
        }
    }

    public String prizeResult(Prize prize) {
        if (prize == Prize.SECOND) {
            return prize.getMatch() + "개 일치, 보너스 볼 일치 " + prize.getPanel() + " - ";
        }
        return prize.getMatch() + "개 일치 " + prize.getPanel() + " - ";
    }

    public void printProfitRate(String profitRate) {
        String message = String.format(PROFIT_RATE, profitRate);
        System.out.println(message);
    }
}
