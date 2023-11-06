package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.Winning;

public class LottoService {

    public List<Lotto> getLottos(Money money) {
        int tickets = money.calculateTicket();
        return new LottoQuantity(tickets).getLottos();
    }

    public Map<Prize, Integer> getPrizeResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        List<Prize> prizes = calculatePrize(lottos, winningNumber, bonusNumber);
        return new PrizeResult(prizes).getResult();
    }

    public List<Integer> getWinningNumbers(String winningNumber) {
        return new Winning(winningNumber).getNumbers();
    }

    public int getBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        return new Bonus(bonusNumber, winningNumbers).getNumber();
    }

    public String getRevenue(Map<Prize, Integer> result, Money money) {
        double rewards = calculateRewards(result);
        return money.calculateRevenue(rewards);
    }

    private List<Prize> calculatePrize(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream().map(lotto -> findPrize(lotto, winningNumbers, bonusNumber)).toList();
    }

    private Prize findPrize(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int count = lotto.countSameNumber(winningNumber);
        boolean bonus = lotto.containsBonus(bonusNumber);
        return Prize.findBySameNumberCountAndBonus(count, bonus);
    }

    private double calculateRewards(Map<Prize, Integer> result) {
        double rewards = 0;
        for (Prize prize : result.keySet()) {
            rewards += prize.getReward() * result.get(prize);
        }
        return rewards;
    }

}
