package lotto.service;

import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class LottoService {

    public HashMap<Integer, Integer> calculateWinningResult(List<List<Integer>> randomSixNumbers, Lotto lotto, int bonusNumber) {
        HashMap<Integer, Integer> winningResult = new HashMap<>(0);

        for (List<Integer> randomSixNumber : randomSixNumbers) {
            int matchingCount = winningCount(randomSixNumber, lotto.getNumbers());
            boolean hasBonus = winningBonusNumber(randomSixNumber, bonusNumber);
            if (!hasBonus) {
                winningResult.put(matchingCount, winningResult.getOrDefault(matchingCount, 0) + 1);
            }
            if (hasBonus && matchingCount == LOTTO_WIN_THIRD) {
                winningResult.put(matchingCount + 2, winningResult.getOrDefault(LOTTO_WIN_SECOND, 0) + 1);
            }
        }

        return winningResult;
    }

    public double calculateTotalProfitMargin(HashMap<Integer, Integer> winningResult, int purchaseAmount) {
        double totalProfit = 0;

        for (Integer key : winningResult.keySet()) {
            int grade = key;
            int count = winningResult.get(key);
            int profit = calculateProfit(grade)*count;

            totalProfit += profit;
        }

        return Math.round((totalProfit/purchaseAmount)*1000)/10.0;
    }

    private int calculateProfit(int grade) {
        if (grade == LOTTO_WIN_FIRST) {
            return LOTTO_WIN_FIRST_PRICE;
        } else if (grade == LOTTO_WIN_SECOND) {
            return LOTTO_WIN_SECOND_PRICE;
        } else if (grade == LOTTO_WIN_THIRD) {
            return LOTTO_WIN_THIRD_PRICE;
        } else if (grade == LOTTO_WIN_FOURTH) {
            return LOTTO_WIN_FOURTH_PRICE;
        } else if (grade == LOTTO_WIN_FIFTH) {
            return LOTTO_WIN_FIFTH_PRICE;
        }
        return 0;
    }

    private int winningCount(List<Integer> randomSixNumber, List<Integer> correctNumber) {
        int count = 0;
        for (Integer correct : correctNumber) {
            if (randomSixNumber.contains(correct)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean winningBonusNumber(List<Integer> randomSixNumber, int bonusNumber) {
        if (randomSixNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
