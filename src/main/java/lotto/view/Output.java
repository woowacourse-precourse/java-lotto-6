package lotto.view;

import lotto.Lotto;
import lotto.constant.WinningCondition;
import lotto.message.Message;

import java.util.List;
import java.util.Map;

public class Output {
    public void printEnteringAmountPrompt() {
        System.out.println(Message.PROMPT_ENTERING_PURCHASE_AMOUNT);
    }

    public void printPurchasedLottoTickets(List<Lotto> tickets) {
        System.out.printf((Message.GUIDE_PURCHASED_QUANTITY) + "%n", tickets.size());

        for (Lotto ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void printLottoWinningNumbersPrompt() {
        System.out.println(Message.PROMPT_ENTERING_WINNING_NUMBERS);
    }

    public void printLottoBonusNumberPrompt() {
        System.out.println(Message.PROMPT_ENTERING_BONUS_NUMBER);
    }

    public void printWinningStatistics(Map<WinningCondition, Integer> result) {
        System.out.println(Message.WINNING_STATISTICS);
        System.out.println(Message.DIVIDER);

        System.out.printf("%s - %d개\n", WinningCondition.THREE_MATCH.getDescription(), result.getOrDefault(WinningCondition.THREE_MATCH, 0));
        System.out.printf("%s - %d개\n", WinningCondition.FOUR_MATCH.getDescription(), result.getOrDefault(WinningCondition.FOUR_MATCH, 0));
        System.out.printf("%s - %d개\n", WinningCondition.FIVE_MATCH.getDescription(), result.getOrDefault(WinningCondition.FIVE_MATCH, 0));
        System.out.printf("%s - %d개\n", WinningCondition.FIVE_MATCH_WITH_BONUS.getDescription(), result.getOrDefault(WinningCondition.FIVE_MATCH_WITH_BONUS, 0));
        System.out.printf("%s - %d개\n", WinningCondition.SIX_MATCH.getDescription(), result.getOrDefault(WinningCondition.SIX_MATCH, 0));
    }

    public void printWinningRoR(double RoR) {
        System.out.printf(Message.GUIDE_TOTAL_ROR + "%n", RoR);
    }
}
