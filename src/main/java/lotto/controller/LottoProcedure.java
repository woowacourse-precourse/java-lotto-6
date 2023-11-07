package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.Size;
import lotto.Util.LottoValue;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Output;

public class LottoProcedure {
    private final int LOTTO_SIZE = 6;
    private final List<Double> reward = new ArrayList<>();
    User user;
    Lotto winningNumber;
    BonusNumber bonusNumber;

    public LottoProcedure() {
        List<Double> reward = List.of(LottoValue.NONE.getReward(),
                LottoValue.FIRST_PLACE.getReward(),
                LottoValue.SECOND_PLACE.getReward(),
                LottoValue.THIRD_PLACE.getReward(),
                LottoValue.FOURTH_PLACE.getReward(),
                LottoValue.FIFTH_PLACE.getReward());
        this.reward.addAll(reward);
    }

    public void lottoProceed() {
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

        for (int j = 0; j < Size.LOTTO_SIZE.getSize(); j++) {
            if (user.getPurchasedLottoNumbers(index).contains(winningNumber.number(j))) {
                count += 1;
            }
        }
        return count;
    }


    public int calculateRank(double count) {
        if (count == LottoValue.FIFTH_PLACE.getNumberOfMatch()) {
            return LottoValue.FIFTH_PLACE.getRank();
        } else if (count == LottoValue.FOURTH_PLACE.getNumberOfMatch()) {
            return LottoValue.FOURTH_PLACE.getRank();
        } else if (count == LottoValue.THIRD_PLACE.getNumberOfMatch()) {
            return LottoValue.THIRD_PLACE.getRank();
        } else if (count == LottoValue.SECOND_PLACE.getNumberOfMatch()) {
            return LottoValue.SECOND_PLACE.getRank();
        } else if (count == LottoValue.FIRST_PLACE.getNumberOfMatch()) {
            return LottoValue.FIRST_PLACE.getRank();
        }
        return LottoValue.NONE.getRank();
    }

    public double checkBonusNumber(double count, List<Integer> winningNumbers, int bonusNumber) {
        if (count == LottoValue.THIRD_PLACE.getNumberOfMatch() & winningNumbers.contains(bonusNumber)) {
            return LottoValue.SECOND_PLACE.getNumberOfMatch();
        }
        return count;
    }

    public double calculateResult() {
        double result = 0;

        for (int i = 1; i < user.rankCountSize(); i++) {
            result += this.reward.get(i) * user.getRankCount(i);
        }
        return result;
    }
}
