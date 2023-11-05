package lotto.controller;

import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoGenerator;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private Map<Rank, Integer> results;

    public void start() {
        payMoney();
        generatePurchasedLottos();
        createWinningNumbers();
        createBonusNumber();
        createResults();
        printResult();
        printPercent();
    }

    private void payMoney() {
        try {
            money = new Money(Input.inputMoney());
            Output.printLottosCount(money.calculateCount());
        } catch (IllegalArgumentException e) {
            payMoney();
        }
    }

    private void generatePurchasedLottos() {
        lottos = new ArrayList<>();
        for(int i = 0 ; i < money.calculateCount() ; i++) {
            Lotto lotto = LottoGenerator.generateLotto();
            lottos.add(lotto);
            Output.printLottos(lotto.toString());
        }
    }

    private void createWinningNumbers() {
        try {
            winningNumbers = new Lotto(Input.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            createWinningNumbers();
        }
    }

    private void createBonusNumber() {
        try {
            bonusNumber = new BonusNumber(Input.inputBonusNumber());
            winningNumbers.validateBonusNumber(bonusNumber);
        } catch(IllegalArgumentException e) {
            createBonusNumber();
        }
    }

    private void createResults() {
        results = new HashMap<>();
        for(Rank rank : Rank.values()) {
            results.put(rank, findRankCount(rank));
        }
    }

    private int findRankCount(Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> sortRank(rank, lotto))
                .count();
    }

    private boolean sortRank(Rank rank, Lotto lotto) {
        if(rank == SECOND) {
            return isSecond(lotto);
        }
        if(rank == THIRD) {
            return isThird(lotto);
        }
        return isElse(rank, lotto);
    }

    private boolean isSecond(Lotto lotto) {
        return lotto.matchNumbers(winningNumbers) == SECOND.getCount()
                && lotto.containsBonusNumber(bonusNumber);
    }

    private boolean isThird(Lotto lotto) {
        return lotto.matchNumbers(winningNumbers) == THIRD.getCount()
                && !lotto.containsBonusNumber(bonusNumber);
    }

    private boolean isElse(Rank rank, Lotto lotto) {
        return lotto.matchNumbers(winningNumbers) == rank.getCount();
    }

    private void printResult() {
        Output.printWinningStatistic();
        for(Rank rank : Rank.values()) {
            Output.printResults(rank.getMessage(), results.get(rank));
        }
    }

    private void printPercent() {
        double sum = 0;
        for(Rank rank : Rank.values()) {
            sum += (rank.getPrize() * results.get(rank));
        }
        Output.printPercent(sum / money.getValue() * 100);
    }
}
