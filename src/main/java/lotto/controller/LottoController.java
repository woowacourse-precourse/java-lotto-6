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
        generateLottos();
        getWinnerNumbers();
        getBonusNumber();
        writeResults();
        printResult();
    }

    private void payMoney() {
        try {
            money = new Money(Input.inputMoney());
            Output.printLottosCount(money.getCount());
        } catch (IllegalArgumentException e) {
            payMoney();
        }
    }

    private void generateLottos() {
        lottos = new ArrayList<>();
        for(int i = 0 ; i < money.getCount() ; i++) {
            Lotto lotto = LottoGenerator.generateLotto();
            lottos.add(lotto);
            Output.printLottos(lotto.toString());
        }
    }

    private void getWinnerNumbers() {
        try {
            winningNumbers = new Lotto(Input.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            getWinnerNumbers();
        }
    }

    private void getBonusNumber() {
        try {
            bonusNumber = new BonusNumber(Input.inputBonusNumber());
            winningNumbers.validateBonusNumber(bonusNumber);
        } catch(IllegalArgumentException e) {
            getBonusNumber();
        }
    }

    private void writeResults() {
        results = new HashMap<>();
        for(Rank rank : Rank.values()) {
            results.put(rank, findRanking(rank));
        }
    }

    private int findRanking(Rank rank) {
        if(rank == SECOND) {
            return findSecond();
        }
        if(rank == THIRD) {
            return findThird();
        }
        return findElse(rank);
    }

    private int findSecond() {
        return  (int) lottos.stream()
                .filter(lotto -> lotto.matchNumbers(winningNumbers) == SECOND.getCount()
                        && lotto.containsBonusNumber(bonusNumber))
                .count();
    }

    public int findThird() {
        return (int) lottos.stream()
                .filter(lotto -> lotto.matchNumbers(winningNumbers) == THIRD.getCount()
                        && !lotto.containsBonusNumber(bonusNumber))
                .count();
    }

    private int findElse(Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.matchNumbers(winningNumbers) == rank.getCount())
                .count();
    }

    private void printResult() {
        Output.printWinningStatistic();
        for(Rank rank : Rank.values()) {
            Output.printResults(rank.getMessage(), results.get(rank));
        }
        printPercent();
    }

    private void printPercent() {
        double sum = 0;
        for(Rank rank : Rank.values()) {
            sum += (rank.getPrize() * results.get(rank));
        }
        Output.printPercent(sum / money.getValue() * 100);
    }
}
