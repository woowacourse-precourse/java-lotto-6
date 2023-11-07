package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTickets;
import lotto.domain.TicketAmount;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;

public class LottoController {
    private TicketAmount ticketAmount;
    private int ticketCount;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public void run() {
        setTicketAmountAndCount();
        setLottoTickets();
        setWinningNumber();
        setBonusNumber();
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
        ticketAmount = InputController.setTicketAmount();
        ticketCount = ticketAmount.calculateTicketAmount();
    }

    private void setLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(ticketCount);
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
}