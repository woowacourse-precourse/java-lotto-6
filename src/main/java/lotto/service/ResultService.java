package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.Policy;
import lotto.domain.Result;
import lotto.domain.User;

public class ResultService {
    public Result addRankResult(User user, LottoAnswer lottoAnswer) {
        Result result = new Result(new LinkedHashMap<>());
        for (Lotto lotto : user.getLottos()) {
            List<Integer> userNumbers = lotto.getNumbers();
            int count = compareNumbers(userNumbers, lottoAnswer.getWinningNumbers().getNumbers());
            boolean isBonus = checkBonusNumber(userNumbers, lottoAnswer.getBounsNumber().getValue());
            if (count >= 3) {
                Policy key = Policy.valueOf(count, isBonus);
                result.getResults().put(key, result.getResults().getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }

    private boolean checkBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }

    private int compareNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public double getProfitRate(User user, Result result) {
        int amount = user.getPurchaseCount();
        int totalProfit = getTotalProfit(result);
        return (totalProfit / (double) (amount * 1000)) * 100;
    }

    private int getTotalProfit(Result result) {
        int totalProfit = 0;
        for (Policy rank : result.getResults().keySet()) {
            if (rank == Policy.FAIL) {
                continue;
            }
            totalProfit += rank.getMoney() * result.getResults().get(rank);
        }
        return totalProfit;
    }
}
