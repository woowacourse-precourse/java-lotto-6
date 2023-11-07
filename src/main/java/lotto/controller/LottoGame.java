package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrizeBreakdown;
import lotto.domain.LottoTicketMaker;
import lotto.domain.Money;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningNumbers;
import lotto.util.LottoGuideMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Money money = repeatUntilValidMoneyCreated();
        List<Lotto> lottoTickets = issueLottoTickets(money);

        WinningNumbers winningNumbers = repeatUntilValidWinningNumbersCreated();
        repeatUntilValidBonusNumberAssigned(winningNumbers);

        showWinningStatistics(winningNumbers, lottoTickets, money);
    }

    private void showWinningStatistics(WinningNumbers winningNumbers, List<Lotto> lottoTickets, Money money) {
        LottoPrizeBreakdown prizeBreakdown = winningNumbers.createLottoPrizeBreakdown(lottoTickets);
        RateOfReturn rateOfReturn = prizeBreakdown.getRateOfReturn(money);
        outputView.showWinningStatistics(prizeBreakdown, rateOfReturn);
    }

    private List<Lotto> issueLottoTickets(Money money) {
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker();
        List<Lotto> lottoTickets = lottoTicketMaker.issueLottoTickets(money);
        outputView.showIssueLottoTickets(lottoTickets);

        return lottoTickets;
    }

    private void repeatUntilValidBonusNumberAssigned(WinningNumbers winningNumbers) {
        while (true) {
            try {
                assignBonusNumberToWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private void assignBonusNumberToWinningNumbers(WinningNumbers winningNumbers) {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_BONUS_NUMBER);
        winningNumbers.setBonusNumber(new BonusNumber(userInput));
    }

    private WinningNumbers repeatUntilValidWinningNumbersCreated() {
        while (true) {
            try {
                return createWinningNumbersFromUserInput();
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbersFromUserInput() {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_WINNING_NUMBER);
        return new WinningNumbers(userInput);
    }

    private Money repeatUntilValidMoneyCreated() {
        while (true) {
            try {
                return createMoneyFromUserInput();
            } catch (IllegalArgumentException e) {
                outputView.showMessage(e.getMessage());
            }
        }
    }

    private Money createMoneyFromUserInput() {
        String userInput = inputWithMessage(LottoGuideMessage.ENTER_PURCHASE_AMOUNT);
        return new Money(userInput);
    }

    private String inputWithMessage(LottoGuideMessage lottoGuideMessage) {
        outputView.showMessage(lottoGuideMessage);
        String userInput = inputView.getUserInput();
        outputView.showSeperateLine();
        return userInput;
    }
}
