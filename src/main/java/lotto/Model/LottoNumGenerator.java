package lotto.Model;

import static lotto.Constants.BudgetConstants.BUDGET_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumGenerator {

    public List<List<Integer>> generateLotteryNumbersGroup(Integer lotteryBudget) {
        Integer numOfLottery = lotteryBudget / BUDGET_UNIT.getPrice();
        List<List<Integer>> lotteryNumbersGroup = new ArrayList<>();
        for (int i = 0; i < numOfLottery; i++) {
            lotteryNumbersGroup.add(generateLotteryNumber());
        }

        return lotteryNumbersGroup;
    }

    public List<Integer> generateLotteryNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
