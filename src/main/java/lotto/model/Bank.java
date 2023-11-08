package lotto.model;

import static lotto.constant.LottoConstant.FIFTH_PLACE;
import static lotto.constant.LottoConstant.FIRST_PLACE;
import static lotto.constant.LottoConstant.FOURTH_PLACE;
import static lotto.constant.LottoConstant.NO_PRIZE;
import static lotto.constant.LottoConstant.SECOND_PLACE;
import static lotto.constant.LottoConstant.THIRD_PLACE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.constant.RuleConstant;

public class Bank {
    public List<Integer> getRanks(List<Lotto> lottos, List<Integer> userNumbers, int bonusNumber) {
        int[] ranks = new int[RuleConstant.RANK_RANGE.getValue()];
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int index = getRankIndex(lottoNumbers, userNumbers, bonusNumber);
            if (index != NO_PRIZE.getIndex()) {
                ranks[index]++;
            }
        }
        return Arrays.stream(ranks).boxed().collect(Collectors.toList());
    }

    public int getProfit(List<Integer> ranks) {
        int profit = RuleConstant.DEFAULT_VALUE.getValue();
        for (int i = RuleConstant.DEFAULT_VALUE.getValue(); i < RuleConstant.RANK_RANGE.getValue(); i++) {
            profit += ranks.get(i) * getPrizeByIndex(i);
        }
        return profit;
    }

    public double getFormatProfitRate(int count, int profit) {
        double profitRate = getProfitRate(count, profit);
        return Math.round(profitRate * RuleConstant.RATE_FORMAT_NUMBER.getValue())
                / (double) RuleConstant.RATE_FORMAT_NUMBER.getValue();
    }

    private int getPrizeByIndex(int index) {
        for (LottoConstant constant : LottoConstant.values()) {
            if (constant.getIndex() == index) {
                return constant.getPrize();
            }
        }
        return RuleConstant.DEFAULT_VALUE.getValue();
    }

    private int getRankIndex(List<Integer> lottoNumbers, List<Integer> userNumbers, int bonusNumber) {
        int rightCount = getRightCount(lottoNumbers, userNumbers);
        boolean bonus = checkBonus(lottoNumbers, bonusNumber);
        return getRank(rightCount, bonus);
    }

    private double getProfitRate(int count, int profit) {
        return (double) profit * RuleConstant.PERCENTAGE_NUMBER.getValue() / (count
                * RuleConstant.LOTTO_PRICE.getValue());
    }

    private int getRank(int count, boolean bonus) {
        if (count == FIFTH_PLACE.getValue()) {
            return FIFTH_PLACE.getIndex();
        }
        if (count == FOURTH_PLACE.getValue()) {
            return FOURTH_PLACE.getIndex();
        }
        if (count == THIRD_PLACE.getValue()) {
            if (bonus) {
                return SECOND_PLACE.getIndex();
            }
            return THIRD_PLACE.getIndex();
        }
        if (count == FIRST_PLACE.getValue()) {
            return FIRST_PLACE.getIndex();
        }
        return NO_PRIZE.getIndex();
    }

    private int getRightCount(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        Set<Integer> sNumbers = new HashSet<>(lottoNumbers);
        sNumbers.addAll(userNumbers);
        return RuleConstant.DOUBLE_LOTTO_RANGE.getValue() - sNumbers.size();
    }

    private boolean checkBonus(List<Integer> lottoNumbers, int bonus) {
        return lottoNumbers.contains(bonus);
    }
}
