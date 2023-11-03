package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private static void displayLottoTickets(int amount, LottoTicket lottoTicket){
        OutputView.printPurchasedLottoTickets(amount, lottoTicket);
    }

    private static void displayResult(Map<Rank, Integer> statistics, int amount){
        OutputView.printStatistics(statistics, amount);
    }
}
