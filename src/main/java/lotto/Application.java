package lotto;

import lotto.generator.Bonus;
import lotto.generator.Purchase;
import lotto.generator.LottoTicket;
import lotto.generator.WinningNumber;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int count = Purchase.purchase();

        List<List<Integer>> ticketBundle = LottoTicket.lottoTicket(count);

        LottoTicket.printTickets(ticketBundle);

        List<Integer> winningNumbers = WinningNumber.getWinningNumber();

        int bonusNumber = Bonus.getBonus();
    }
}
