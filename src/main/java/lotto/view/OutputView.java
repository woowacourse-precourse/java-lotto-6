package lotto.view;

import static lotto.constant.message.OutputMessage.BONUS_RESULT;
import static lotto.constant.message.OutputMessage.PRIZE_RESULT;
import static lotto.constant.message.OutputMessage.PROFIT_RATE;
import static lotto.constant.message.OutputMessage.PURCHASE_COUNT_RESULT;

import java.util.List;
import java.util.Map;
import lotto.constant.Prize;
import lotto.domain.Lotto;

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

    public void printPrizeResult(Map<Prize, Integer> result) {
        result.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.NONE)
                .forEach(entry -> printPrizeEntry(entry.getKey(), entry.getValue()));
    }

    private void printPrizeEntry(Prize prize, int count) {
        String message = String.format(PRIZE_RESULT, prize.getMatch(), prize.getPanel(), count);
        if (prize == Prize.SECOND) {
            message = String.format(BONUS_RESULT, prize.getPanel(), count);
        }
        System.out.println(message);
    }

    public void printProfitRate(String profitRate) {
        String message = String.format(PROFIT_RATE, profitRate);
        System.out.println(message);
    }
}
