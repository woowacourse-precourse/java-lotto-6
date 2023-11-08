package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.Size;
import lotto.Util.LottoValue;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Output;

public class LottoController {
    private final List<Double> reward = new ArrayList<>();
    User user;
    Lotto winningNumber;
    BonusNumber bonusNumber;

    public LottoController() {
        List<Double> reward = List.of(LottoValue.NONE.getReward(),
                LottoValue.FIRST_PLACE.getReward(),
                LottoValue.SECOND_PLACE.getReward(),
                LottoValue.THIRD_PLACE.getReward(),
                LottoValue.FOURTH_PLACE.getReward(),
                LottoValue.FIFTH_PLACE.getReward());
        this.reward.addAll(reward);
    }

    public void lottoProcedure() {
        user = Setting.getPayment();
        Output.printAboutPurchase(user);
        winningNumber = Setting.getLotto();
        bonusNumber = Setting.getBonusNumber(winningNumber);
        produceStatistics();
        Output.printStatistics(user.rankCount());
        Output.printYield(calculateYield(user.payment()));
    }

    public void produceStatistics() {
        for (int i = 0; i < user.purchasedLottoNumbers().size(); i++) {
            List<Integer> purchasedLottoNumber = user.purchasedLottoNumbers().get(i);
            double numberOfMatch = countNumbefOfMatch(purchasedLottoNumber, winningNumber.numbers());
            increaseRankCount(calculateRank(numberOfMatch));
        }
    }

    public void increaseRankCount(int rank) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (rank == lottoValue.getRank()) {
                int currentRankCount = user.rankCount().get(lottoValue.getRank());
                user.rankCount().set(lottoValue.getRank(), currentRankCount + 1);
                return;
            }
        }
    }

    public double countNumbefOfMatch(List<Integer> purchasedLottoNumber, List<Integer> winningNumber) {
        double numberOfMatch = 0;

        for (Integer number : winningNumber) {
            if (purchasedLottoNumber.contains(number)) {
                numberOfMatch += 1;
            }
        }
        if (numberOfMatch == LottoValue.THIRD_PLACE.getNumberOfMatch()) {
            numberOfMatch = checkBonusNumber(purchasedLottoNumber);
        }
        return numberOfMatch;
    }

    public double checkBonusNumber(List<Integer> purchasedLottoNumber) {
        if (purchasedLottoNumber.contains(bonusNumber.bonusNumber())) {
            return LottoValue.SECOND_PLACE.getNumberOfMatch();
        }
        return LottoValue.THIRD_PLACE.getNumberOfMatch();
    }

    public int calculateRank(double numberOfMatch) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (numberOfMatch == lottoValue.getNumberOfMatch()) {
                return lottoValue.getRank();
            }
        }
        return LottoValue.NONE.getRank();
    }

    public double calculateYield(double payment) {
        double yield = 0;

        for (int i = 1; i < user.rankCount().size(); i++) {
            yield += this.reward.get(i) * user.rankCount().get(i);
        }
        return yield / payment * 100;
    }
}
