package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.TotalResult;
import lotto.enums.Messages;
import lotto.enums.Reward;

public class View {
    public void moneyInputGuideMsg() {
        System.out.println(Messages.PRICE_INPUT_GUIDE.getMsg());
    }

    public void printLottoInfo(Tickets tickets) {
        printEmptyLine();
        System.out.println(tickets.getTicketAmount() + Messages.TICKET_AMOUNT.getMsg());
        List<Lotto> unmodifiableTickets = tickets.getTickets();
        for (Lotto ticket : unmodifiableTickets) {
            printLottoNumbers(ticket);
        }
    }

    private void printLottoNumbers(Lotto ticket) {
        System.out.println(ticket.getNumbers());
    }

    public void winningNumberInputGuideMsg() {
        printEmptyLine();
        System.out.println(Messages.WINNING_NUMBER_INPUT_GUIDE.getMsg());
    }

    public void bonusNumberInputGuideMsg() {
        printEmptyLine();
        System.out.println(Messages.BONUS_NUMBER_INPUT_GUIDE.getMsg());
    }

    public void hitResultTitle() {
        printEmptyLine();
        System.out.println(Messages.RESULT_TITLE.getMsg());
    }

    public void printHitResult(TotalResult totalResult) {
        EnumMap<Reward, Integer> result = totalResult.getTotalResult();

        for (Reward reward : result.keySet()) {
            int amount = result.get(reward);
            printHitLine(reward, amount);
        }
    }

    private void printHitLine(Reward reward, int amount) {
        int hitCnt = reward.getHitCnt();
        long price = reward.getReward();

        if (reward.getBonusCnt() == 1) {
            System.out.println(
                    hitCnt + Messages.BONUS_HIT.getMsg() + String.format("%,d", price) + Messages.PRICE_TAIL.getMsg()
                            + amount
                            + Messages.AMOUNT.getMsg());
            return;
        }
        System.out.println(
                hitCnt + Messages.HIT.getMsg() + String.format("%,d", price) + Messages.PRICE_TAIL.getMsg() + amount
                        + Messages.AMOUNT.getMsg());
    }

    public void printRateOfReturn(double rate) {
        System.out.println(Messages.RATE_OF_RETURN_HEAD.getMsg() + String.format("%.1f", rate)
                + Messages.RATE_OF_RETURN_TAIL.getMsg());
    }

    private void printEmptyLine() {
        System.out.println("");
    }
}
