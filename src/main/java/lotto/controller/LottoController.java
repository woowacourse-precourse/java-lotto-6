package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public void start(){
        // 구입금액 입력
        int amount = lottoService.displayPurchase();

        // 구매 항목 출력
        LottoTicket lottoTickets = lottoService.getLottoTicket(amount);
        displayLottoTickets(amount, lottoTickets);

        // 당첨번호 입력
        List<Integer> winningNumbers = lottoService.displayWinningNumber();

        // 보너스 번호 입력
        int bonusNumber = lottoService.displayBonusNumber(winningNumbers);

        // 이기는 로또 티켓
        WinningLottoTicket winningLottoTicket = lottoService.makeWinningLottoTicket(winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = lottoService.getStatistics(lottoTickets, winningLottoTicket);

        displayResult(statistics, amount);
    }

    private static void displayLottoTickets(int amount, LottoTicket lottoTicket){
        OutputView.printPurchasedLottoTickets(amount, lottoTicket);
    }

    private static void displayResult(Map<Rank, Integer> statistics, int amount){
        OutputView.printStatistics(statistics, amount);
    }
}
