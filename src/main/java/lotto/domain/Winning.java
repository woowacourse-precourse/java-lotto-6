package lotto.domain;

import lotto.view.Message;
import lotto.view.View;

public class Winning {
    private final int match;
    private final boolean bonus;
    private final int prize;

    private int ticketCount = 0;

    public Winning(int match,boolean bonus, int prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public boolean getBonus() {
        return bonus;
    }

    public void addTicketCount() {
        this.ticketCount ++;
    }
    public int calculatePrize() {
        return ticketCount * prize;
    }

    public void printResult() {
        String bonusText = "";
        if (bonus) {
            bonusText = Message.RESPONSE_BONUS_TEXT.getMessage();
        }
        View.printMessageWithArgs(
                Message.RESPONSE_MATCHED,
                match,
                bonusText,
                Message.RESPONSE_PRIZE_FORMATTER.getMessage(prize),
                ticketCount
        );
    }
}
