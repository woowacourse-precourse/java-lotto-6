package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.INT_NULL;
import static lotto.constant.GeneralConstant.PRIZE_RANK_WEIGHT;
import static lotto.constant.GeneralConstant.PRIZE_RANK_INDEXES;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import lotto.util.NumberValidator;

public enum LottoCompany {
    INSTANCE;
    private static List<Integer> prizeNumbers = new ArrayList<Integer>();
    private static int bonusNumber;

    public static void setPrizeNumbers(List<Integer> prizeNumbers) {
        NumberValidator.validateLottoNumbers(prizeNumbers);
        LottoCompany.prizeNumbers = prizeNumbers;
    }

    public static void setBonusNumber(int bonusNumber) {
        NumberValidator.validateBonusNumber(bonusNumber);
        LottoCompany.bonusNumber = bonusNumber;
    }

    public static int matchPrize(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        int weight = calculatePrizeRank(set);
        if(weight == PRIZE_RANK_WEIGHT.get("THIRD")) {
            weight = calculateBonusNumber(weight, set);
        }
        return getRankIndex(weight);
    }

    private static int calculatePrizeRank(Set<Integer> set) {
        int weight = ZERO;
        for(int number : prizeNumbers) {
            weight = matchPrizeNumber(weight, set, number);
        }
        return weight;
    }

    private static int matchPrizeNumber(int weight, Set<Integer> set, int number) {
        if(set.contains(number)) {
            return ++weight;
        }
        return weight;
    }

    private static int calculateBonusNumber(int weight, Set<Integer> set) {
        if(set.contains(bonusNumber)) {
           return PRIZE_RANK_WEIGHT.get("SECOND");
        }
        return weight;
    }

    private static int getRankIndex(int weight) {
        for (Map.Entry<String, Integer> entry : PRIZE_RANK_WEIGHT.entrySet()) {
            String rank = findRankName(weight, entry);
            if(rank != null) {
                return getRankIndex(rank);
            }
        }
        return INT_NULL;
    }

    private static String findRankName(int weight, Map.Entry<String, Integer> entry) {
        if (Objects.equals(entry.getValue(), weight)) {
            return entry.getKey();
        }
        return null;
    }

    private static int getRankIndex(String rank) {
        for(Map.Entry<Integer, String> entry : PRIZE_RANK_INDEXES.entrySet()){
            int index = findRankIndex(rank, entry);
            if(index != INT_NULL) {
                return index;
            }
        }
        return INT_NULL;
    }

    private static int findRankIndex(String rank, Map.Entry<Integer, String> entry) {
        if(Objects.equals(entry.getValue(), rank)) {
            return entry.getKey();
        }
        return INT_NULL;
    }
}