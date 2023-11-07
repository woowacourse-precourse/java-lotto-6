package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {
    public void start() {
        // 구매 금액 입력
        Cash cash = getCash();

        // 구매 로또 출력
        List<Lotto> lottos = getLottos(cash);
        OutputView.displayLottos(lottos);

        // 당첨 번호, 보너스 번호 입력
        WinningNumbers winningNumbers = getWinningNumbers();

        // 당첨 통계 출력
        List<Rank> ranks = getRanks(lottos, winningNumbers);
        WinningYield yield = getYield(cash, ranks);
        OutputView.displayWinningDetails(ranks, yield);
    }

    private Cash getCash() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = InputView.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return new Cash(purchaseAmount);
    }

    private List<Lotto> getLottos(Cash cash) {
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        Customer customer = new Customer(cash, lottoSeller);
        return customer.purchaseLottos();
    }

    private WinningNumbers getWinningNumbers() {
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private WinningNumber getWinningNumber() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = InputView.getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return new WinningNumber(winningNumbers);
    }

    private BonusNumber getBonusNumber() {
        int number;
        while (true) {
            try {
                number = InputView.getBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return new BonusNumber(number);
    }

    private List<Rank> getRanks(List<Lotto> lottos, WinningNumbers winningNumbers) {
        WinningRanks winningRanks = new WinningRanks(lottos, winningNumbers);
        return winningRanks.calculateRanks();
    }

    private WinningYield getYield(Cash cash, List<Rank> ranks) {
        Profit profit = new Profit();
        profit.calculateAmount(ranks);
        return new WinningYield(cash, profit);
    }
}
