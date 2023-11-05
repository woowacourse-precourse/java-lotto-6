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
        List<Double> reward = List.of(0.0, 0.0, 0.0, 5000.0, 50000.0, 1500000.0, 200000000.0, 30000000.0);
        this.reward.addAll(reward);
    }

    public void startLotto() {
        user = Setting.getPayment();
        Output.printAboutPurchase(user);
        lotto = Setting.getLotto();
        bonusNumber = Setting.getBonusNumber(lotto);
        Output.printWinningStatisticsMessage();
        checkRank();
        Output.printStatistics(user.winningNumberCount());
        System.out.println("총 수익률은 " + String.format("%.1f",calculateYield()/user.payment() * 100) +"%입니다.");
    }

    public double calculateYield() {
        double sum = 0;
        for (int i=MINIMUM_NUMBER_OF_SAME;i<user.winningNumberCount().size();i++) {
            if (user.winningNumberCount().get(i) != 0) {
                sum += this.reward.get(i);
            }
        }
        return sum;
    }

    public void checkRank() {
        for (int i=0;i<user.purchasedLottoNumbersSize();i++) {
            int count = 0;
            for (int j=0;j<LOTTO_SIZE;j++) {
                if (user.PurchasedLottoNumbers().get(i).contains(lotto.numbers().get(j))) {
                    count += 1;
                }
            }
            if (count == 5) {
                count = checkBonusNumber(user.PurchasedLottoNumbers().get(i), bonusNumber.bonusNumber());
            }
            user.increaseWinningNumberCount(count);
        }
    }

    public int checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            return 7;
        }
        return 5;
    }
}
