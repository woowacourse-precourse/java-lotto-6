package service;

import model.AllLotto;
import model.ResultLottos;

import java.util.List;

public class LottoService {
    private final AllLotto allLotto;
    private final List<Integer> winningLotto;
    private final Integer bonus;

    public LottoService(AllLotto allLotto, List<Integer> winningLotto, Integer bonus) {
        this.allLotto = allLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private Integer findEqualNumber(List<Integer> winningLotto, Integer index) {
        return (int) allLotto.getLotto(index).stream()
                .filter(winningLotto::contains)
                .count();
    }

    private Boolean findEqualBonus(Integer bonusNumber, Integer index) {
        return allLotto.getLotto(index).contains(bonusNumber);
    }

    public ResultLottos createResults() {
        ResultLottos resultLottos = new ResultLottos();
        for (int i = 0; i < allLotto.size(); i++) {
            Integer equalNumber = findEqualNumber(winningLotto, i);
            Boolean bonusNumber = findEqualBonus(bonus, i);
            resultLottos.addResultLotto(equalNumber, bonusNumber);
        }
        return resultLottos;
    }

    public double calculateReturnRate(ResultLottos lottos, Long money) {
        return (double) (lottos.sumResult() * 100) / money;
    }
}
