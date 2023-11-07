package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoValue;
import lotto.RankValue;
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
        List<Double> reward = List.of(LottoValue.LOSE.getValue(),
                LottoValue.FIRST_REWARD.getValue(),
                LottoValue.SECOND_REWARD.getValue(),
                LottoValue.THIRD_REWARD.getValue(),
                LottoValue.FOURTH_REWARD.getValue(),
                LottoValue.FIFTH_REWARD.getValue());
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

        for (int j = 0; j < LottoValue.LOTTO_SIZE.getValue(); j++) {
            if (user.getPurchasedLottoNumbers(index).contains(winningNumber.number(j))) {
                count += 1;
            }
        }
        return count;
    }


    public int calculateRank(double count) {
        if (count == LottoValue.MATCH_NUMBER_TO_WIN_FIFTH.getValue()) {
            return RankValue.FIFTH_PLACE.getRankValue();
        } else if (count == LottoValue.MATCH_NUMBER_TO_WIN_FOURTH.getValue()) {
            return RankValue.FOURTH_PLACE.getRankValue();
        } else if (count == LottoValue.MATCH_NUMBER_TO_WIN_THIRD.getValue()) {
            return RankValue.THIRD_PLACE.getRankValue();
        } else if (count == LottoValue.MATCH_NUMBER_TO_WIN_SECOND.getValue()) {
            return RankValue.SECOND_PLACE.getRankValue();
        } else if (count == LottoValue.MATCH_NUMBER_TO_WIN_FIRST.getValue()) {
            return RankValue.FIRST_PLACE.getRankValue();
        }
        return RankValue.LOSE.getRankValue();
    }

    public double checkBonusNumber(double count, List<Integer> winningNumbers, int bonusNumber) {
        if (count == LottoValue.MATCH_NUMBER_TO_WIN_THIRD.getValue() & winningNumbers.contains(bonusNumber)) {
            return LottoValue.MATCH_NUMBER_TO_WIN_SECOND.getValue();
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
