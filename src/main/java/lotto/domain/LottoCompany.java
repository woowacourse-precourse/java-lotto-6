package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.INT_NULL;
import static lotto.constant.GeneralConstant.PRIZE_RANK_WEIGHT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.NumberValidator;

public enum LottoCompany {
    INSTANCE;
    private static List<Integer> prizeNumbers = new ArrayList<Integer>();
    private static int bonusNumber;

    public void setPrizeNumbers(List<Integer> prizeNumbers) {
        NumberValidator.validateLottoNumbers(prizeNumbers);
        LottoCompany.prizeNumbers = prizeNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        NumberValidator.validateBonusNumber(bonusNumber);
        LottoCompany.bonusNumber = bonusNumber;
    }

    public int matchPrize(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        int weight = calculatePrizeRank(set);
        if(weight == PRIZE_RANK_WEIGHT.get("THIRD")) {
            weight = calculateBonusNumber(weight, set);
        }
        return getRankIndex(weight);
    }

    private int calculatePrizeRank(Set<Integer> set) {
        int weight = ZERO;
        for(int number : prizeNumbers) {
            weight = matchPrizeNumber(weight, set, number);
        }
        return weight;
    }

    private int matchPrizeNumber(int weight, Set<Integer> set, int number) {
        if(set.contains(number)) {
            return ++weight;
        }
        return weight;
    }

    private int calculateBonusNumber(int weight, Set<Integer> set) {
        if(set.contains(bonusNumber)) {
           return PRIZE_RANK_WEIGHT.get("SECOND");
        }
        return weight;
    }

    private int getRankIndex(int weight) {
        int index = ZERO;
        for(int value : PRIZE_RANK_WEIGHT.values()) {
            if(weight == value) {
                return index;
            }
            index++;
        }
        return INT_NULL;
    }
}