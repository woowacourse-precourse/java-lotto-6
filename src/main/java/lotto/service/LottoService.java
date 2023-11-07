package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.type.ConditionSetting;
import lotto.type.Win;

public class LottoService {

    private static final int MIN_NUMBER = ConditionSetting.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = ConditionSetting.MAX_NUMBER.getValue();
    private static final int COUNT = ConditionSetting.COUNT.getValue();
    private static final int PRICE_UNIT = ConditionSetting.PRICE_UNIT.getValue();
    private static final int PERCENT = 100;

    public int calcAmount(int cash) {
        return cash / PRICE_UNIT;
    }

    public List<Lotto> makeLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.addAll(randomNumbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }


    public int[] compare(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] result = new int[COUNT + 2];
        for (int i = 0; i < lottos.size(); i++) {
            int collectCount = lottos.get(i).getNumbers().stream().filter(l -> winningLotto.getNumbers()
                    .stream().anyMatch(Predicate.isEqual(l))).collect(Collectors.toList()).size();
            if (collectCount == 6) {
                collectCount++;
            }
            if (collectCount == 5) {
                collectCount += checkBonus(bonusNumber, lottos.get(i));
            }
            result[collectCount]++;
        }
        return result;
    }

    public int checkBonus(int bonusNumber, Lotto winningLotto) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (int i = 0; i < COUNT; i++) {
            if (numbers.get(i) == bonusNumber) {
                return 1;
            }
        }
        return 0;
    }

    public double calcProfit(int[] result, int cash) {
        int idx = COUNT + 1;
        double sum = 0;
        sum += Win.FIRST.getPrize() * result[idx--];
        sum += Win.SECOND.getPrize() * result[idx--];
        sum += Win.THIRD.getPrize() * result[idx--];
        sum += Win.FOURTH.getPrize() * result[idx--];
        sum += Win.FIFTH.getPrize() * result[idx--];
        double profit = (sum / cash) * PERCENT;
        return profit;
    }

}
