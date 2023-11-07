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
    private Result result;

    public void run() {
        setTicketAmountAndCount();
        setLottoTickets();
        setWinningNumber();
        setBonusNumber();

        calculateResult();
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

    protected void calculateResult() {
        OutputView.printWinningStatusMessage();
        result = lottoTickets.calculateLottoRank(winningNumber, bonusNumber);
        OutputView.printLottoResultMessage(result);
    }
}