package lotto.controller;

import static lotto.view.Prompt.WAIT_FOR_BONUS_NUMBER;
import static lotto.view.Prompt.WAIT_FOR_PURCHASE_AMOUNT;
import static lotto.view.Prompt.WAIT_FOR_WINNING_NUMBERS;

import lotto.BonusNumber;
import lotto.ConsoleUserInterface;
import lotto.LotteryPortfolio;
import lotto.Lotto;
import lotto.LottoService;
import lotto.PurchaseAmount;
import lotto.RandomLotteryNumberProvider;
import lotto.UserInputReader;
import lotto.view.PortfolioConsoleView;

public class LottoController {

    private PurchaseAmount purchaseAmount;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private LottoService service;
    private LotteryPortfolio portfolio;

    public LottoController() {
    }

    public void readPurchaseAmount() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_PURCHASE_AMOUNT);
        purchaseAmount = new PurchaseAmount(UserInputReader.readPureNumber());
    }

    public void issueRequiredAmountOfLottery() {
        portfolio = new LotteryPortfolio();
        for (int i = 0; i < purchaseAmount.getTicketQuantity(); i++) {
            portfolio.add(new Lotto(RandomLotteryNumberProvider.lotteryNumbers()));
        }
    }

    public void showPurchaseInformation() {
        ConsoleUserInterface.printMessage(
                String.format("%d개를 구매했습니다.", purchaseAmount.getTicketQuantity())
        );
        ConsoleUserInterface.printMessage(
                PortfolioConsoleView.holdingsView(portfolio).toString()
        );
    }

    public void readWinningNumbers() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_WINNING_NUMBERS);
        winningLotto = new Lotto(UserInputReader.readMultiplePureNumbers());
    }

    public void readBonusNumber() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_BONUS_NUMBER);
        bonusNumber = new BonusNumber(winningLotto, UserInputReader.readPureNumber());
    }

    public void showPortfolioResult() {
        service = new LottoService(winningLotto, bonusNumber);
        ConsoleUserInterface.printMessage(
                PortfolioConsoleView.reportView(service.analyzePortfolio(portfolio))
                        .toString()
        );
    }
}
