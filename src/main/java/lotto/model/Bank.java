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
import lotto.constant.NumberConstant;

public class Bank {
    public List<Integer> getRanks(List<Lotto> lottos, List<Integer> userNumbers, int bonusNumber){
        int[] ranks = new int[NumberConstant.RANK_RANGE];
        for (Lotto lotto : lottos){
            List<Integer> lottoNumbers = lotto.getNumbers();
            int index = getRankIndex(lottoNumbers, userNumbers, bonusNumber);
            if (index != NO_PRIZE.getValue()){
                ranks[index]++;
            }
        }
        return Arrays.stream(ranks).boxed().collect(Collectors.toList());
    }

    public int getProfit(List<Integer> ranks){
        int profit = NumberConstant.DEFAULT_VALUE;
        for (int i = NumberConstant.DEFAULT_VALUE; i < ranks.size(); i++){
            profit += ranks.get(i) * getPrizeByIndex(i);
        }
        return profit;
    }

    public double getFormatProfitRate(int money, int profit){
        double profitRate = getProfitRate(money, profit);
        return Math.round(profitRate * NumberConstant.RATE_FORMAT_NUMBER) / NumberConstant.RATE_FORMAT_NUMBER;
    }

    private int getPrizeByIndex(int index){
        for(LottoConstant constant : LottoConstant.values()){
            if (constant.getIndex() == index){
                return constant.getPrize();
            }
        }
        return NumberConstant.DEFAULT_VALUE;
    }

    private int getRankIndex(List<Integer> lottoNumbers, List<Integer> userNumbers, int bonusNumber){
        int rightCount = getRightCount(lottoNumbers, userNumbers);
        boolean bonus = checkBonus(lottoNumbers, bonusNumber);
        return getRank(rightCount, bonus);
    }

    private double getProfitRate(int money, int profit){
        return (double) profit / money;
    }

    private int getRank(int count, boolean bonus){
        if (count == FIFTH_PLACE.getValue()){
            return FIFTH_PLACE.getIndex();
        }
        if (count == FOURTH_PLACE.getValue()){
            return FOURTH_PLACE.getIndex();
        }
        if (count == THIRD_PLACE.getValue()){
            if (bonus)
                return SECOND_PLACE.getIndex();
            return THIRD_PLACE.getIndex();
        }
        if (count == FIRST_PLACE.getValue()){
            return FIRST_PLACE.getIndex();
        }
        return NO_PRIZE.getIndex();
    }

    private int getRightCount(List<Integer> lottoNumbers, List<Integer> userNumbers){
        Set<Integer> sNumbers = new HashSet<>(lottoNumbers);
        sNumbers.addAll(userNumbers);
        return NumberConstant.DOUBLE_LOTTO_RANGE - sNumbers.size();
    }

    private boolean checkBonus(List<Integer> lottoNumbers, int bonus){
        return lottoNumbers.contains(bonus);
    }
}
