package lotto.controller;

import static lotto.view.Prompt.WAIT_FOR_BONUS_NUMBER;
import static lotto.view.Prompt.WAIT_FOR_PURCHASE_AMOUNT;
import static lotto.view.Prompt.WAIT_FOR_WINNING_NUMBERS;

import lotto.BonusNumber;
import lotto.LotteryTicket;
import lotto.io.ConsoleUserInterface;
import lotto.LotteryPortfolio;
import lotto.service.LottoService;
import lotto.PurchaseAmount;
import lotto.RandomLotteryNumberProvider;
import lotto.io.UserInputReader;
import lotto.view.PortfolioConsoleView;

public class LottoController {

    private PurchaseAmount purchaseAmount;
    private LotteryTicket winningLotteryTicket;
    private BonusNumber bonusNumber;
    private LottoService service;
    private LotteryPortfolio portfolio;

    public LottoController() {
    }

    public void readPurchaseAmount() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_PURCHASE_AMOUNT);
        purchaseAmount = PurchaseAmount.amountOf(UserInputReader.readPureNumber());
    }

    public void issueRequiredAmountOfLottery() {
        portfolio = new LotteryPortfolio();
        for (int i = 0; i < purchaseAmount.getTicketQuantity(); i++) {
            portfolio.add(new LotteryTicket(RandomLotteryNumberProvider.lotteryNumbers()));
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
        winningLotteryTicket = LotteryTicket.create(UserInputReader.readMultiplePureNumbers());
    }

    public void readBonusNumber() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_BONUS_NUMBER);
        bonusNumber = BonusNumber.create(winningLotteryTicket, UserInputReader.readPureNumber());
    }

    public void showPortfolioResult() {
        service = new LottoService(winningLotteryTicket, bonusNumber);
        ConsoleUserInterface.printMessage(
                PortfolioConsoleView.reportView(service.analyzePortfolio(portfolio))
                        .toString()
        );
    }
}
