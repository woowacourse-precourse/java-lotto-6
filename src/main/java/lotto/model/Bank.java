package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.constant.NumberConstant;

public class Bank {
    public List<Integer> getRanks(List<Lotto> lottos, List<Integer> userNumbers, int bonusNumber){
        int[] ranks = new int[5];
        for (Lotto lotto : lottos){
            List<Integer> lottoNumbers = lotto.getNumbers();
            int index = getRankIndex(lottoNumbers, userNumbers, bonusNumber);
            if (index != LottoConstant.NO_PRIZE_INDEX.getValue()){
                ranks[index]++;
            }
        }
        return Arrays.stream(ranks).boxed().collect(Collectors.toList());
    }

    public double getFormatProfitRate(int money, int profit){
        double profitRate = getProfitRate(money, profit);
        return Math.round(profitRate * 10) / 10.0;
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
        if (count == 3){
            return LottoConstant.FIFTH_PLACE_INDEX.getValue();
        }
        if (count == 4){
            return LottoConstant.FOURTH_PLACE_INDEX.getValue();
        }
        if (count == 5){
            if (bonus)
                return LottoConstant.SECOND_PLACE_INDEX.getValue();
            return LottoConstant.THIRD_PLACE_INDEX.getValue();
        }
        if (count == 6){
            return LottoConstant.FIRST_PLACE_INDEX.getValue();
        }
        return LottoConstant.NO_PRIZE_INDEX.getValue();
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
