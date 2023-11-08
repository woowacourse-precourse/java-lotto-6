package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<LottoTicket> tickets = purchaseTickets(purchaseAmount);
        printTickets(tickets);

        WinningNumbers winningNumbers = inputWinningNumbers();
        WinningResult winningResult = checkWinning(tickets, winningNumbers, purchaseAmount);
        printResult(winningResult);
    }

    private int inputPurchaseAmount() {
        return InputView.inputLottoPurchaseAmount();
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> winningNumbersAndBonus = InputView.inputWinningNumbers();
        int bonusNumber = winningNumbersAndBonus.remove(winningNumbersAndBonus.size() - 1);
        return new WinningNumbers(winningNumbersAndBonus, bonusNumber);
    }

    private void printTickets(List<LottoTicket> tickets) {
        OutputView.printTickets(tickets);
    }

    private void printResult(WinningResult winningResult) {
        OutputView.printResult(winningResult);
    }

    private List<LottoTicket> purchaseTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LottoTicket.PRICE;
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> lottoMachine.issueTicket())
                .collect(Collectors.toList());
    }

    private WinningResult checkWinning(List<LottoTicket> tickets, WinningNumbers winningNumbers, int purchaseAmount) {
        WinningResult winningResult = new WinningResult(purchaseAmount);
        for (LottoTicket ticket : tickets) {
            int matchCount = winningNumbers.calculateMatchCount(ticket.getLotto());
            boolean matchBonus = winningNumbers.isMatchBonus(ticket.getLotto());
            Prize prize = Prize.valueOf(matchCount, matchBonus);
            winningResult.incrementPrizeCount(prize);
        }
        return winningResult;
    }
}
