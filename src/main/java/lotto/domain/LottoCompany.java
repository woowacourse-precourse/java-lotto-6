package lotto.domain;

import static lotto.constant.GeneralConstant.NUMBERS_SIZE;
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
        int weight = calcWeight(set);
        weight = calcBonusNumber(weight, set);
        return getRankIndex(weight);
    }

    private int calcWeight(Set<Integer> set) {
        int weight = ZERO;
        for(int number : prizeNumbers) {
            weight = matchPrizeNumber(weight, set, number);
        }
        if(weight == prizeNumbers.size()) {
            weight = PRIZE_RANK_WEIGHT.get("FIRST");
        }
        return weight;
    }

    private int matchPrizeNumber(int weight, Set<Integer> set, int number) {
        if(set.contains(number)) {
            return ++weight;
        }
        return weight;
    }

    private int calcBonusNumber(int weight, Set<Integer> set) {
        if(weight == PRIZE_RANK_WEIGHT.get("THIRD")) {
            return matchBonusNumber(set);
        }
        return weight;
    }

    private int matchBonusNumber(Set<Integer> set) {
        if(set.contains(bonusNumber)) {
           return PRIZE_RANK_WEIGHT.get("SECOND");
        }
        return PRIZE_RANK_WEIGHT.get("THIRD");
    }

    private int getRankIndex(int weight) {
        if(weight >= PRIZE_RANK_WEIGHT.get("FIFTH")) {
            return calcRankIndex(weight);
        }
        return INT_NULL;
    }

    private int calcRankIndex(int weight) {
        return weight - PRIZE_RANK_WEIGHT.get("FIFTH");
    }
}