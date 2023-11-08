package lotto.controller;

import lotto.domain.*;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.ManualNumberStrategy;
import lotto.domain.number.NumberStrategy;
import lotto.domain.number.RandomNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private static List<Lotto> lottoTickets;
    private int lottoTicketAmount;
    private int purchaseMoney;
    private NumberStrategy winningLotto;
    private int bonusNumber;

    public void run() {
        try {
            LottoGame();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void LottoGame() {
        purchaseLotto();
        printTickets();
        setWinningNumbers();
        setBonusNumber();

        LottoDraw lottoDraw = new LottoDraw(lottoTickets);
        Map<LottoResult, Integer> resultCounts = lottoDraw.extractResult(winningLotto, bonusNumber);
        OutputView.printWinningMessage();
        printResult(resultCounts);

        EarningsRate earningsRate = new EarningsRate();
        OutputView.printEarningsRate(earningsRate.getEarningsRate(purchaseMoney, resultCounts));
    }

    private void setBonusNumber() {
        while (true) {
            try {
                bonusNumber = InputView.inputBonusNumber();
                new BonusNumber(winningLotto.generateNumber(), bonusNumber);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void setWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumber = InputView.inputWinningNumbers();
                winningLotto = new ManualNumberStrategy(inputWinningNumber);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void printTickets() {
        OutputView.printTicketCount(lottoTicketAmount);
        for (Lotto lottoTicket : lottoTickets) {
            OutputView.printTicketList(lottoTicket.getNumbers());
        }
    }

    private void purchaseLotto() {
        while (true) {
            try {
                purchaseMoney = InputView.inputBuyLotto();
                lottoTicketAmount = new TicketCount(purchaseMoney).getTicketCount();
                makeLottoTickets(lottoTicketAmount);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void makeLottoTickets(int lottoTicketAmount) {
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        lottoTickets = IntStream.range(0, lottoTicketAmount)
                .mapToObj(i -> randomNumberStrategy.generateNumber())
                .collect(Collectors.toList());
    }

    private void printResult(Map<LottoResult, Integer> resultCounts) {
        for (LottoResult result : LottoResult.values()) {
            Integer count = resultCounts.get(result);
            String description = result.getResultDescription(count);
            OutputView.printText(description);
        }
    }
}
