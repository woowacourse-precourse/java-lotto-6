package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        output.showMoneyInputMessage();
        Money money = repeatMakeMoney();

        LottoTickets lottoTickets = lottoMachine.buy(money);
        output.showLottoTickets(lottoTickets);

        WinningCondition winningCondition = makeWinningCondition();
        Map<Lotto, Rank> rankByLotto = winningCondition.findRankByLotto(lottoTickets);
        Map<Rank, Integer> winningResult = makeWinningResult(rankByLotto);
        double totalReturn = winningCondition.calculateTotalReturn(money.getAmount(), winningResult);
        output.showWinningStats(winningResult, totalReturn);
    }

    private Money repeatMakeMoney() {
        try {
            return new Money(toInt(input.readMoney()));
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatMakeMoney();
        }
    }

    private WinningCondition makeWinningCondition() {
        output.showWinningNumbersInputMessage();
        Lotto winningLotto = repeatMakeWinningLotto();

        output.showBonusNumberInputMessage();
        int bonusNumber = repeatReadBonusNumber();

        return new WinningCondition(winningLotto, bonusNumber);
    }

    private Lotto repeatMakeWinningLotto() {
        try {
            return lottoMachine.makeWinningLotto(input.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatMakeWinningLotto();
        }
    }

    private int repeatReadBonusNumber() {
        try {
            return toInt(input.readBonusNumber());
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatReadBonusNumber();
        }
    }

    private Map<Rank, Integer> makeWinningResult(Map<Lotto, Rank> rankByLotto) {
        Map<Rank, Integer> winningResult = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        for (Rank rank : rankByLotto.values()) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }

        return winningResult;
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
