package lotto.service;

import java.util.List;
import lotto.constant.LottoConstants;
import lotto.controller.userIO.InputController;
import lotto.controller.userIO.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoRandomGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    private InputController inputController;
    private OutputView outputView;

    public void init() {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        inputController = new InputController(inputView, inputValidator);
        outputView = new OutputView();
    }

    public void run() {
        init();
        startLottoGame();
    }

    private void startLottoGame() {
        int budget = inputController.getBudget();
        List<Lotto> lottoTicketsPurchased = purchaseLottoTickets(budget, new LottoRandomGenerator());

        WinningLotto winningLotto = inputController.getWinningLottoTicket();

        prepareStatistics(winningLotto, lottoTicketsPurchased, budget);
    }

    private List<Lotto> purchaseLottoTickets(int budget, LottoGenerator lottoGenerator) {
        int quantity = calculateQuantity(budget);
        List<Lotto> lottoTicketsPurchased = lottoGenerator.generateLottoTickets(quantity);

        outputView.printLottoTicketsCount(lottoTicketsPurchased.size());
        outputView.printLottoTickets(lottoTicketsPurchased);
        return lottoTicketsPurchased;
    }

    private void prepareStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased, int budget) {
        WinningStatistics winningStatistics
                = new WinningStatistics(winningLotto, lottoTicketsPurchased);

        outputView.printWinningStatistics(winningStatistics);

        double rateOfReturn = calculateRateOfReturn(budget, winningStatistics.calculateSumOfPrize());
        outputView.printRateOfReturn(rateOfReturn);
    }

    private int calculateQuantity(int budget) {
        return budget / LottoConstants.THE_PRICE_OF_ONE_LOTTO_TICKET;
    }

    private Double calculateRateOfReturn(int budget, Long earnedAmount) {
        return earnedAmount * 100 / (double) budget;
    }
}
