package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.HitNumber;
import util.PrizeMoney;

public class Calculator {
    PrizeStatistics prizeStatistics = PrizeStatistics.getInstance();
    private static final int DIVIDING_UNIT = 1000;
    private static final double PERCENTAGE_FACTOR = 100;

    public int calculateMoneyToLottoCount(int money) {
        return money / DIVIDING_UNIT;
    }

    public void calculatePrizeDescribe(Lotto lottoNumber, List<Integer> prizeNumber, int bonusNumber) {
        int matchedNumberCount = getMatchedNumberCount(lottoNumber, prizeNumber);

        if (matchedNumberCount == HitNumber.HIT_THREE_NUMBER.getHitNumber()) {
            prizeStatistics.winFifthPrize();
        }

        if (matchedNumberCount == HitNumber.HIT_FOUR_NUMBER.getHitNumber()) {
            prizeStatistics.winFourthPrize();
        }

        if (matchedNumberCount == HitNumber.HIT_FIVE_NUMBER.getHitNumber()) {
            prizeStatistics.winThirdPrize();
        }

        if (matchedNumberCount == HitNumber.HIT_FIVE_NUMBER.getHitNumber() && isLottoNumberContainBonusNumber(
                lottoNumber, bonusNumber)) {
            prizeStatistics.winSecondPrize();
        }

        if (matchedNumberCount == HitNumber.HIT_SIX_NUMBER.getHitNumber()) {
            prizeStatistics.winFirstPrize();
        }
    }

    private int getMatchedNumberCount(Lotto lottoNumber, List<Integer> prizeNumber) {
        Set<Integer> lottoNumberChangeToSet = new HashSet<>(lottoNumber.getNumbers());
        Set<Integer> prizeNumberChangeToSet = new HashSet<>(prizeNumber);

        lottoNumberChangeToSet.retainAll(prizeNumberChangeToSet);
        return lottoNumberChangeToSet.size();
    }

    private boolean isLottoNumberContainBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public String calculateEarningRate(int purchaseAmount) {
        double totalPrize = (PrizeMoney.PRIZE_MONEY_5TH.getPrizeMoney() * prizeStatistics.getFifthPrize())
                + (PrizeMoney.PRIZE_MONEY_4TH.getPrizeMoney() * prizeStatistics.getFourthPrize())
                + (PrizeMoney.PRIZE_MONEY_3RD.getPrizeMoney() * prizeStatistics.getThirdPrize())
                + (PrizeMoney.PRIZE_MONEY_2ND.getPrizeMoney() * prizeStatistics.getSecondPrize())
                + (PrizeMoney.PRIZE_MONEY_1ST.getPrizeMoney() * prizeStatistics.getFirstPrize());

        double earningRate = totalPrize / purchaseAmount * PERCENTAGE_FACTOR;

        return String.format("%.1f%%", earningRate);
    }
}
