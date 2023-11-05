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
    Lotto lotto;
    BonusNumber bonusNumber;

    public LottoProcedure() {
        List<Double> reward = List.of(0.0, 200000000.0, 30000000.0, 1500000.0, 50000.0, 5000.0);
        this.reward.addAll(reward);
    }

    public void startLotto() {
        user = Setting.getPayment();
        Output.printAboutPurchase(user);
        lotto = Setting.getLotto();
        bonusNumber = Setting.getBonusNumber(lotto);
        produceStatistics();
        Output.printStatistics(user.rankCount(), calculateWinnings(), user.payment());
    }

    public void produceStatistics() {
        for (int i = 0; i < user.purchasedLottoNumbersSize(); i++) {
            double count = 0;
            for (int j = 0; j < LOTTO_SIZE; j++) {
                if (user.PurchasedLottoNumbers().get(i).contains(lotto.numbers().get(j))) {
                    count += 1;
                }
            }
            if (count == 5) {
                count = checkBonusNumber(user.PurchasedLottoNumbers().get(i), bonusNumber.bonusNumber());
            }
            user.increaseRankCount(rank(count));
        }
    }

    public int rank(double count) {
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

    public double checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            return 5.5;
        }
        return 5;
    }

    public double calculateWinnings() {
        double winnings = 0;
        for (int i = MINIMUM_NUMBER_OF_SAME; i < user.rankCount().size(); i++) {
            if (user.rankCount().get(i) != 0) {
                winnings += this.reward.get(i);
            }
        }
        return winnings;
    }
}
