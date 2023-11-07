package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeNumbers;
import lotto.domain.PrizeResult;
import lotto.domain.TicketPurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        TicketPurchaseAmount amount = inputAmount();

        LottoTicket lottoTickets = buyTickets(amount);

        PrizeNumbers prizeNumbers = createprizeNumbers();

        PrizeResult winningResult = getPrizeResult(lottoTickets, prizeNumbers);

        printResult(amount, winningResult);
    }

    private TicketPurchaseAmount inputAmount() {
        try {
            return new TicketPurchaseAmount(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputAmount();
        }
    }

    private LottoTicket buyTickets(TicketPurchaseAmount amount) {
        int ticketCount = amount.calculateLottoCount();
        OutputView.printTicketCount(ticketCount);

        LottoTicket lottoTickets = new LottoTicket(ticketCount);
        OutputView.printTicket(lottoTickets);
        return lottoTickets;
    }

    private PrizeNumbers createprizeNumbers() {
        Lotto inputLottoNumbers = getInputLottoNumbers();
        BonusNumber bonusNumber = getBonusNumber();

        return getprizeNumbers(inputLottoNumbers, bonusNumber);
    }

    private Lotto getInputLottoNumbers() {
        try {
            return new Lotto(InputView.inputprizeNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getInputLottoNumbers();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            return new BonusNumber(InputView.inputBonusBall());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getBonusNumber();
        }
    }

    private PrizeNumbers getprizeNumbers(Lotto lottoNumbers, BonusNumber bonusNumber) {
        try {
            return new PrizeNumbers(lottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getprizeNumbers(lottoNumbers, getBonusNumber());
        }
    }

    private PrizeResult getPrizeResult(LottoTicket lottoTickets, PrizeNumbers prizeNumbers) {
        return lottoTickets.calculateWinningStatistic(prizeNumbers);
    }

    private void printResult(TicketPurchaseAmount amount, PrizeResult winningResult) {
        OutputView.printWinningStatistic(winningResult);
        OutputView.printProfit(amount.calculateProfit(winningResult.calculatePrizeSum()));
    }

}
