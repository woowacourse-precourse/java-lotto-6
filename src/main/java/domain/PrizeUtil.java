package domain;


import constant.Constants;
import constant.Prize;
import java.util.Map;

public class PrizeUtil {

    public String calculateEarningRate(int lottoCnt, Map<Integer, Integer> lottoScore, int hasFiveAndbonusNumber) {
        double prizeMoney = (double) calculatePrizeMoney(lottoScore, hasFiveAndbonusNumber);
        double earningRate = prizeMoney / (lottoCnt * Constants.LOTTO_PRICE) * 100;
        return String.format("%.1f", earningRate);
    }

    private int calculatePrizeMoney(Map<Integer, Integer> lottoScore, int hasFiveAndbonusNumber) {
        return lottoScore.get(3) * Prize.THREE.getPrize() + lottoScore.get(4) * Prize.FOUR.getPrize()
                + lottoScore.get(5) * Prize.FIVE.getPrize() + lottoScore.get(6) * Prize.SIX.getPrize() +
                hasFiveAndbonusNumber * Prize.FIVE_AND_BONUS.getPrize();
    }


}
