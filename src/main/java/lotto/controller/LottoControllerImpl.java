package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoControllerImpl implements LottoController {
    public LottoControllerImpl(Console console, LottoService lottoService) {
        this.console = console;
        this.lottoService = lottoService;
    }

    private final Console console;
    private final LottoService lottoService;

    @Override
    public void play() {
        final List<Lotto> purchasedLotteries = new ArrayList<>();
        final int payment = getPayment();
        final int lotteryCount = payment / 1000;

        addPurchasedLotteries(purchasedLotteries, lotteryCount);
        displayPurchasedLotteries(purchasedLotteries);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
        List<Integer> matchResult = lottoService.lotteryMatch(purchasedLotteries, winningLotto, bonusNumber);
        double rateOfReturn = lottoService.getRateOfReturn(payment, lottoService.calculateReward(matchResult));

        console.displayResult(matchResult, rateOfReturn);
    }

    private int getPayment() {
        int payment = 0;

        while (payment == 0) {
            try {
                payment = lottoService.parsePayment(console.inputPayment());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return payment;
    }

    private Lotto getWinningLotto() {
        Lotto winningLotto = null;

        while (winningLotto == null) {
            try {
                winningLotto = lottoService.parseWinningNumbers(console.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningLotto;
    }

    private int getBonusNumber(Lotto winningLotto) {
        int bonusNumber = 0;

        while (bonusNumber == 0) {
            try {
                bonusNumber = lottoService.parseBonusNumber(console.inputBonusNumber(), winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private void displayPurchasedLotteries(List<Lotto> purchasedLotteries) {
        for (Lotto lottery : purchasedLotteries) {
            console.displayPurchasedLottery(lottery.getNumbers());
        }

        System.out.println();
    }

    private void addPurchasedLotteries(List<Lotto> purchasedLotteries, int lotteryCount) {
        console.displayPurchasedLotteryCount(lotteryCount);

        for (int i = 0; i < lotteryCount; i++) {
            purchasedLotteries.add(lottoService.generatePurchasedLottery());
        }
    }
}
