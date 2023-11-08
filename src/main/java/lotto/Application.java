package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        Target target = new Target();
        Score score = new Score();

        purchase.getTickets();

        Lotto lotto = target.targetNums();
        int bonusNumber = target.bonusNum();

        score.getScore(lotto, purchase.getTicketArray(), bonusNumber);
        score.winner();
        score.printRate();
    }
}
