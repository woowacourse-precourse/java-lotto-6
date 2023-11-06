package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {
    PrizeDescribe prizeDescribe = PrizeDescribe.getInstance();

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
        double totalPrize = (5000.0 * prizeDescribe.getFifthPrize()) + (50000.0 * prizeDescribe.getFourthPrize())
                + (1500000.0 * prizeDescribe.getThirdPrize()) + (30000000.0 * prizeDescribe.getSecondPrize())
                + (2000000000.0 * prizeDescribe.getFirstPrize());

        double earningRate = totalPrize / purchaseAmount * 100;

        String formattedEarningRate = String.format("%.1f%%", earningRate);

        return formattedEarningRate;
    }

}
