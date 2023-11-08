package lotto.controller;

import static lotto.view.WinningNumbersInput.winningNumbers;

import java.util.List;

import lotto.domain.Deposit;
import lotto.domain.Lotto;
import lotto.domain.ProfitRate;
import lotto.domain.RankCount;
import lotto.domain.WinningNumbers;

import lotto.view.DepositInput;
import lotto.view.LottoOutput;
import lotto.view.ProfitRateOutput;
import lotto.view.WinningResultOutput;

public class LottoController {

    public void start() {
        LottoOutput.deposit();

        Deposit deposit = DepositInput.deposit();
        LottoOutput.ticketsCount(deposit.getLottoTicketsCount());

        List<Lotto> tickets = LottoTicketFactory.lottoTickets(deposit.getLottoTicketsCount());
        LottoOutput.lottoTickets(tickets);

        WinningNumbers winningNumber = winningNumbers();

        RankCount rankCount = new RankCount(tickets, winningNumber);
        int totalWinnings = rankCount.calculateTotalWinnings();

        WinningResultOutput.winningResult(rankCount);

        ProfitRate profitRate = new ProfitRate(totalWinnings, deposit.getDeposit());
        ProfitRateOutput.profitRate(profitRate.getProfitRate());
    }
}


