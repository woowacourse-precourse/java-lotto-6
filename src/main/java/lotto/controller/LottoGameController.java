package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoRandomGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.utils.Parser;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public void init() {
        InputValidator inputValidator = new InputValidator();
        inputView = new InputView(inputValidator);
        outputView = new OutputView();
    }

    public void run() {
        init();
        startLottoGame();
    }

    private void startLottoGame() {
        int budget = askBudget();
        int quantity = createQuantity(budget);
        List<Lotto> lottoTicketsPurchased = createLottoTickets(new LottoRandomGenerator(), quantity);
        WinningLotto winningLotto = askWinningLottoTicket();

        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, lottoTicketsPurchased);
        outputView.printWinningStatistics(winningStatistics);

        double rateOfReturn = winningStatistics.getRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    public int askBudget() {
        String budget = inputView.scanBudget();
        return Integer.parseInt(budget);
    }

    private WinningLotto askWinningLottoTicket() {
        Lotto winningNumbers = askWinningNumbers();
        int bonusNumber = askBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto askWinningNumbers() {
        String userInput = inputView.scanWinningNumbers();

        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        return new Lotto(lotto);
    }

    private int askBonusNumber() {
        return Integer.parseInt(inputView.scanBonusNumber());
    }

    public int createQuantity(int budget) {
        int quantity = budget / LottoConstants.THE_PRICE_OF_ONE_LOTTO_TICKET;
        outputView.printLottoTicketsCount(quantity);
        return quantity;
    }

    private List<Lotto> createLottoTickets(LottoGenerator lottoGenerator, int quantity) {
        List<Lotto> lottoTickets = lottoGenerator.generateLottoTickets(quantity);
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }
}