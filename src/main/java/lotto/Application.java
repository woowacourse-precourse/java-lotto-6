package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        LottoService lottoService = new LottoService();

        int cash = lottoController.inputCash();

        int ticket = lottoService.getTicket(cash);
        List<Lotto> lottoBundle = lottoService.getLottoBundle(ticket);
        lottoController.showLottoBundle(ticket, lottoBundle);

        List<Integer> winningNumbers = lottoController.inputWinningNumbers();
        int bonusNumber = lottoController.inputBonusNumber();
        winningNumbers.add(bonusNumber);

        lottoController.showWinningStatistics(cash, winningNumbers, lottoBundle);
    }
}
