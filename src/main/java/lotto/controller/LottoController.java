package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTickets;
import lotto.domain.Result;
import lotto.domain.TicketAmount;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;

public class LottoController {
    private TicketAmount ticketAmount;
    private int ticketCount;
    private LottoTickets lottoTickets;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public void run() {
        set();

        Result result = calculateResult();
        display(result);
    }

    private void set() {
        setTicketAmountAndCount();
        setLottoTickets();
        setWinningNumber();
        setBonusNumber();
    }

    private void display(Result result) {
        displayResult(result);
        displayRateOfReturn(result);
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
        ticketAmount = InputController.setTicketAmount();
        ticketCount = ticketAmount.calculateTicketAmount();
    }

    private void setLottoTickets() {
        lottoTickets = new LottoTickets(ticketCount);
        OutputView.printLottoNumbers(ticketCount, lottoTickets);
    }

    private void setWinningNumber() {
        OutputView.printLottoInputMessage();
        winningNumber = InputController.setWinningNumber();
    }

    private void setBonusNumber() {
        OutputView.printBonusNumberInputMessage();
        bonusNumber = InputController.setBonusNumber(winningNumber);
    }

    private Result calculateResult() {
        return lottoTickets.calculateLottoRank(winningNumber, bonusNumber);
    }

    private void displayResult(Result result) {
        OutputView.printWinningStatusMessage();
        OutputView.printLottoResultMessage(result);
    }

    private double calculateRateOfReturn(Result result) {
        return ticketAmount.calculateRateOfReturn(result);
    }

    private void displayRateOfReturn(Result result) {
        double rateOfReturn = calculateRateOfReturn(result);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}