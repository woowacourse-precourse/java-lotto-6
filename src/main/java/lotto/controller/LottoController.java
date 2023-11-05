package lotto.controller;

import static lotto.domain.Ranking.SECOND;
import static lotto.domain.Ranking.THIRD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoGenerator;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private Map<Ranking, Integer> results;

    public void start() {
        buyLottos();
        getWinnerNumbers();
        getBonusNumber();
        getResults();
    }

    private void buyLottos() {
        payMoney();
        generateLottos();
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
        bonusNumber = new BonusNumber(Input.inputBonusNumber());
        try {
            winningNumbers.validateBonusNumber(bonusNumber);
        } catch(IllegalArgumentException e) {
            getBonusNumber();
        }
    }

    private void getResults() {
        writeResults();
        printResult();
    }

    private void writeResults() {
        results = new HashMap<>();
        for(Ranking ranking : Ranking.values()) {
            results.put(ranking, findRanking(ranking));
        }
    }

    private int findRanking(Ranking ranking) {
        if(ranking == SECOND) {
            return findSecond();
        }
        if(ranking == THIRD) {
            return findThird();
        }
        return findElse(ranking);
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

    private int findElse(Ranking ranking) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.matchNumbers(winningNumbers) == ranking.getCount())
                .count();
    }

    private void printResult() {
        Output.printWinningStatic();
        for(Ranking ranking : Ranking.values()) {
            Output.printResults(ranking.getMessage(), results.get(ranking));
        }
        printPercent();
    }

    private void printPercent() {
        double sum = 0;
        for(Ranking ranking : Ranking.values()) {
            sum += (ranking.getPrize() * results.get(ranking));
        }
        Output.printPercent(sum / money.getValue() * 100);
    }
}
