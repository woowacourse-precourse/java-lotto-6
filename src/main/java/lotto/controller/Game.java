package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.dto.Lottos;
import lotto.dto.Ranks;
import lotto.dto.WinningNumbers;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {
    public void start() {
        // 구매 금액 입력
        Cash cash = getCash();

        // 구매 로또 출력
        Lottos lottos = getLottos(cash);
        OutputView.displayLottos(lottos);

        // 당첨 번호, 보너스 번호 입력
        WinningNumbers winningNumbers = getWinningNumbers();

        // 당첨 통계 출력
        Ranks ranks = getRanks(lottos, winningNumbers);
        WinningYield yield = getYield(cash, ranks);
        OutputView.displayWinningDetails(ranks, yield);
    }

    public void finish() {
        Console.close();
    }

    private Cash getCash() {
        while (true) {
            try {
                return new Cash(getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }

    private Lottos getLottos(Cash cash) {
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        Customer customer = new Customer(cash, lottoSeller);
        return customer.purchaseLottos();
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(getWinningLotto(), getBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        return new Lotto(getNumbers());
    }

    private List<Integer> getNumbers() {
        return InputView.getWinningNumbers();
    }

    private BonusNumber getBonusNumber() {
        return new BonusNumber(getNumber());
    }

    private int getNumber() {
        return InputView.getBonusNumber();
    }

    private Ranks getRanks(Lottos lottos, WinningNumbers winningNumbers) {
        WinningRanks winningRanks = new WinningRanks(lottos, winningNumbers);
        return winningRanks.calculateRanks();
    }

    private WinningYield getYield(Cash cash, Ranks ranks) {
        Profit profit = new Profit();
        profit.calculateAmount(ranks);
        return new WinningYield(cash, profit);
    }
}
