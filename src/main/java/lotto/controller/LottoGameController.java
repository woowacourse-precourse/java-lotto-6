package lotto.controller;

import java.util.List;
import lotto.constant.LottoConstants;
import lotto.controller.userIO.InputController;
import lotto.controller.userIO.InputValidator;
import lotto.controller.userIO.OutputController;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoRandomGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputController inputController;
    private OutputController outputController;

    public void init() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();

        inputController = new InputController(inputView, inputValidator);
        outputController = new OutputController(outputView);
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

        outputController.printLottoTicketsCount(lottoTicketsPurchased.size());
        outputController.printLottoTickets(lottoTicketsPurchased);
        return lottoTicketsPurchased;
    }

    private void prepareStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased, int budget) {
        WinningStatistics winningStatistics
                = new WinningStatistics(winningLotto, lottoTicketsPurchased);
        outputController.printWinningStatistics(winningStatistics);

        double rateOfReturn = calculateRateOfReturn(budget, winningStatistics.calculateSumOfPrize());
        outputController.printRateOfReturn(rateOfReturn);
    }

    private int calculateQuantity(int budget) {
        return budget / LottoConstants.THE_PRICE_OF_ONE_LOTTO_TICKET;
    }

    private Double calculateRateOfReturn(int budget, Long earnedAmount) {
        return earnedAmount * 100 / (double) budget;
    }
}
