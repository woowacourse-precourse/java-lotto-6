package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Results;
import lotto.domain.Tickets;
import lotto.domain.Winning;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        Tickets tickets = getValidTickets();

        List<Lotto> lottos = Lotto.createLottos(tickets.getNumberOfTickets());
        View.printLottos(lottos);

        Winning winning = getValidWinning();
        Bonus bonus = getValidBonus(winning);

        Results results = Results.of(lottos, winning, bonus);

        View.printString(results.makeResultToString());
        //View.printString(results.makeProfitRateToString());
    }

    private static Tickets getValidTickets() {
        while(true) {
            try {
                return new Tickets(View.readPayment());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Winning getValidWinning() {
        while(true) {
            try {
                return new Winning(View.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Bonus getValidBonus(Winning winning) {
        while(true) {
            try {
                return new Bonus(winning, View.readBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}