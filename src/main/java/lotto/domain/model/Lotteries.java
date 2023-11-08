package lotto.domain.model;

import lotto.constant.RankConstant;
import lotto.constant.RegularConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {
    List<Lotto> lotteries = new ArrayList<>();

    public boolean add(Lotto lotto) {
        return this.lotteries.add(lotto);
    }

    public void showLotteries() {
        for (Lotto lotto : lotteries) {
            lotto.showNumbers();
        }
    }

    public Map<String, Integer> produceStatistics(final WinningNumber winningNumber, final BonusNumber bonusNumber) {
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 0);


        for (Lotto lotto : lotteries) {
            String result = lotto.calculateRank(winningNumber, bonusNumber);

            if (!result.equals(RankConstant.NONE)) statics.put(result, statics.get(result) + 1);
        }

        return statics;
    }

    public double calculateTotalReturnAsPercent(final int inputMoney, final Map<String, Integer> statistics) {
        long totalReturn = statistics.get(RankConstant.FIRST) * RankConstant.FIRST_WINNINGS
                + statistics.get(RankConstant.SECOND) * RankConstant.SECOND_WINNINGS
                + statistics.get(RankConstant.THIRD) * RankConstant.THIRD_WINNINGS
                + statistics.get(RankConstant.FOURTH) * RankConstant.FOURTH_WINNINGS
                + statistics.get(RankConstant.FIFTH) * RankConstant.FIFTH_WINNINGS;

        double profitPercentage = (totalReturn / (double) inputMoney) * RegularConstant.PERCENT;

        return roundToFirstDecimalPlaces(profitPercentage);
    }

    private double roundToFirstDecimalPlaces(double number) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(RegularConstant.FIRST_DECIMAL_PLACE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
