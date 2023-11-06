package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Output;

public class LottoProcedure {
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int LOTTO_SIZE = 6;
    private final List<Double> reward = new ArrayList<>();
    User user;
    Lotto winningNumber;
    BonusNumber bonusNumber;

    public LottoProcedure() {
        List<Double> reward = List.of(Values.LOSE.getValue(),
                Values.FIRST_REWARD.getValue(),
                Values.SECOND_REWARD.getValue(),
                Values.THIRD_REWARD.getValue(),
                Values.FOURTH_REWARD.getValue(),
                Values.FIFTH_REWARD.getValue());
        this.reward.addAll(reward);
    }

    public void lottoProgress() {
        user = Setting.getPayment();
        Output.printAboutPurchase(user);
        winningNumber = Setting.getLotto();
        bonusNumber = Setting.getBonusNumber(winningNumber);
        produceStatistics();
        Output.printStatistics(user.rankCount(), calculateResult(), user.payment());
    }

    public void produceStatistics() {
        for (int i = 0; i < user.purchasedLottoNumbersSize(); i++) {
            double count = increaseCount(i);
            count = checkBonusNumber(count,
                    user.getPurchasedLottoNumbers(i),
                    bonusNumber.bonusNumber());
            user.increaseRankCount(calculateRank(count));
        }
    }

    public double increaseCount(int index) {
        double count = 0;

        for (int j = 0; j < LOTTO_SIZE; j++) {
            if (user.getPurchasedLottoNumbers(index).contains(winningNumber.number(j))) {
                count += 1;
            }
        }
        return count;
    }


    public int calculateRank(double count) {
        if (count == 3) {
            return 5;
        } else if (count == 4) {
            return 4;
        } else if (count == 5) {
            return 3;
        } else if (count == 5.5) {
            return 2;
        } else if (count == 6) {
            return 1;
        }
        return 0;
    }

    public double checkBonusNumber(double count, List<Integer> winningNumbers, int bonusNumber) {
        if (count == Values.MATCH_NUMBER_TO_WIN_THIRD.getValue() & winningNumbers.contains(bonusNumber)) {
            return Values.MATCH_NUMBER_TO_WIN_SECOND.getValue();
        }
        return count;
    }

    public double calculateResult() {
        double result = 0;

        for (int i = 1; i < user.rankCountSize(); i++) {
            if (user.getRankCount(i) != 0) {
                result += this.reward.get(i) * user.getRankCount(i);
            }
        }
        return result;
    }
}
