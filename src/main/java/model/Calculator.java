package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.HitNumber;
import util.PrizeMoney;

public class Calculator {
    PrizeStatistics prizeStatistics = PrizeStatistics.getInstance();
    LottoBundle lottoBundle = LottoBundle.getInstance();
    private static final int DIVIDING_UNIT = 1000;
    private static final double PERCENTAGE_FACTOR = 100;

    public int calculateMoneyToLottoCount(int purchaseAmount) {
        return purchaseAmount / DIVIDING_UNIT;
    }

    public void calculatePrizeStatistics(List<Integer> prizeNumber, int bonusNumber) {
        for (Lotto lottoNumber : lottoBundle.getLottoBundle()) {
            int matchedNumberCount = getMatchedNumberCount(lottoNumber, prizeNumber);
            isResultFifthPlace(matchedNumberCount);
            isResultFourthPlace(matchedNumberCount);
            isResultThirdPlace(matchedNumberCount);
            isResultSecondPlace(bonusNumber, lottoNumber, matchedNumberCount);
            isResultFirstPlace(matchedNumberCount);
        }
    }

    private void isResultFirstPlace(int matchedNumberCount) {
        if (matchedNumberCount == HitNumber.HIT_SIX_NUMBER.getHitNumber()) {
            prizeStatistics.winFirstPrize();
        }
    }

    private void isResultSecondPlace(int bonusNumber, Lotto lottoNumber, int matchedNumberCount) {
        if (matchedNumberCount == HitNumber.HIT_FIVE_NUMBER.getHitNumber() && isLottoNumberContainBonusNumber(
                lottoNumber, bonusNumber)) {
            prizeStatistics.winSecondPrize();
        }
    }

    private void isResultThirdPlace(int matchedNumberCount) {
        if (matchedNumberCount == HitNumber.HIT_FIVE_NUMBER.getHitNumber()) {
            prizeStatistics.winThirdPrize();
        }
    }

    private void isResultFourthPlace(int matchedNumberCount) {
        if (matchedNumberCount == HitNumber.HIT_FOUR_NUMBER.getHitNumber()) {
            prizeStatistics.winFourthPrize();
        }
    }

    private void isResultFifthPlace(int matchedNumberCount) {
        if (matchedNumberCount == HitNumber.HIT_THREE_NUMBER.getHitNumber()) {
            prizeStatistics.winFifthPrize();
        }
    }

    private int getMatchedNumberCount(Lotto lottoNumber, List<Integer> prizeNumber) {
        Set<Integer> lottoNumberDeleteDuplicate = new HashSet<>(lottoNumber.getNumbers());
        Set<Integer> prizeNumberDeleteDuplicate = new HashSet<>(prizeNumber);

        lottoNumberDeleteDuplicate.retainAll(prizeNumberDeleteDuplicate);
        return lottoNumberDeleteDuplicate.size();
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
