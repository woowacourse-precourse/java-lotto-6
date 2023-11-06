package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.PrizeMoney;

public class Calculator {
    PrizeStatistics prizeDescribe = PrizeStatistics.getInstance();
    private static final int DIVIDING_UNIT = 1000;

    public int calculateMoneyToLottoCount(int money) {
        return money / DIVIDING_UNIT;
    }

    public void calculatePrizeDescribe(Lotto lottoNumber, List<Integer> prizeNumber, int bonusNumber) {
        int matchedNumberCount = getMatchedNumberCount(lottoNumber, prizeNumber);

        if (matchedNumberCount == 3) {
            prizeDescribe.winFifthPrize();
        }

        if (matchedNumberCount == 4) {
            prizeDescribe.winFourthPrize();
        }

        if (matchedNumberCount == 5) {
            prizeDescribe.winThirdPrize();
        }

        if (matchedNumberCount == 5 && isLottoNumberContainBonusNumber(lottoNumber, bonusNumber)) {
            prizeDescribe.winSecondPrize();
        }

        if (matchedNumberCount == 6) {
            prizeDescribe.winFirstPrize();
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
        double totalPrize = (PrizeMoney.PRIZE_MONEY_5TH.getPrizeMoney() * prizeDescribe.getFifthPrize())
                + (PrizeMoney.PRIZE_MONEY_4TH.getPrizeMoney() * prizeDescribe.getFourthPrize())
                + (PrizeMoney.PRIZE_MONEY_3RD.getPrizeMoney() * prizeDescribe.getThirdPrize())
                + (PrizeMoney.PRIZE_MONEY_2ND.getPrizeMoney() * prizeDescribe.getSecondPrize())
                + (PrizeMoney.PRIZE_MONEY_1ST.getPrizeMoney() * prizeDescribe.getFirstPrize());

        double earningRate = totalPrize / purchaseAmount * 100;

        String formattedEarningRate = String.format("%.1f%%", earningRate);

        return formattedEarningRate;
    }

}
