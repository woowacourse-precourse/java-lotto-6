package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        //
        Cash cash = getCash();

        List<Lotto> lottos = getLottos(cash);

        OutputView.displayLottos(lottos);

        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            try {
                winningNumbers = InputView.getWinningNumbers();
                // 입력이 유효하면 계속 진행
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        Integer number = 0;

        while (true) {
            try {
                number = InputView.getBonusNumber();
                // 입력이 유효하면 계속 진행
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(number);

        WinningNumbers winningNumbers1 = new WinningNumbers(winningNumber, bonusNumber);
        WinningRanks winningRanks = new WinningRanks(lottos, winningNumbers1);

        winningRanks.calculateRanks();

        Profit profit = new Profit();
        profit.calculateAmount(winningRanks.getRanks());

        WinningYield winningYield = new WinningYield(cash, profit);

        OutputView.displayWinningDetails(winningRanks.getRanks(), winningYield);
    }

    private Cash getCash() {
        int purchaseAmount = 0;
        while (true) {
            try {
                purchaseAmount = InputView.getPurchaseAmount();
                // 입력이 유효하면 계속 진행
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return new Cash(purchaseAmount);
    }

    private List<Lotto> getLottos(Cash cash) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoSeller lottoSeller = new LottoSeller(lottoNumberGenerator);

        Customer customer = new Customer(cash, lottoSeller);

        return customer.purchaseLottos();
    }
}
