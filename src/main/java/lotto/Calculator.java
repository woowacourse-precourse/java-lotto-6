package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {
    private int fifthPrize = 0;
    private int fourthPrize = 0;
    private int thirdPrize = 0;
    private int secondPrize = 0;
    private int firstPrize = 0;

    public void calculatePrizeDescribe(Lotto lottoNumber, List<Integer> prizeNumber, int bonusNumber) {
        int matchedNumberCount = getMatchedNumberCount(lottoNumber, prizeNumber);

        if (matchedNumberCount == 3) {
            fifthPrize += 1;
        }

        if (matchedNumberCount == 4) {
            fourthPrize += 1;
        }

        if (matchedNumberCount == 5) {
            thirdPrize += 1;
        }

        if (matchedNumberCount == 5 && isLottoNumberContainBonusNumber(lottoNumber, bonusNumber)) {
            secondPrize += 1;
        }

        if (matchedNumberCount == 6) {
            firstPrize += 1;
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
        double totalPrize = (5000.0 * fifthPrize) + (50000.0 * fourthPrize) + (1500000.0 * thirdPrize)
                + (30000000.0 * secondPrize) + (2000000000.0 * firstPrize);

        double earningRate = totalPrize / purchaseAmount * 100;

        String formattedEarningRate = String.format("%.1f%%", earningRate);

        return formattedEarningRate;
    }

    public int getFifthPrize() {
        return fifthPrize;
    }

    public int getFourthPrize() {
        return fourthPrize;
    }

    public int getThirdPrize() {
        return thirdPrize;
    }

    public int getSecondPrize() {
        return secondPrize;
    }

    public int getFirstPrize() {
        return firstPrize;
    }
}
