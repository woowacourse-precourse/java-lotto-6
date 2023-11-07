package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
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

    public void finish() {
        Console.close();
    }

    private Cash getCash() {
        return new Cash(getPurchaseAmount());
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                return InputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getLottos(Cash cash) {
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        Customer customer = new Customer(cash, lottoSeller);
        return customer.purchaseLottos();
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(getWinningNumber(), getBonusNumber());
    }

    private WinningNumber getWinningNumber() {
        return new WinningNumber(getNumbers());
    }

    private List<Integer> getNumbers() {
        while (true) {
            try {
                return InputView.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber() {
        return new BonusNumber(getNumber());
    }

    private int getNumber() {
        while (true) {
            try {
                return InputView.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
