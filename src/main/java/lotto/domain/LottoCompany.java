package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.THIRD_RANK;
import static lotto.constant.GeneralConstant.PRIZE_RANK_WEIGHTS;
import static lotto.constant.GeneralConstant.SECOND_RANK_WEIGHT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        int count = calculatePrizeRank(numbers);
        if(count == THIRD_RANK) {
            count = calculateBonusNumber(numbers, count);
        }

        return PRIZE_RANK_WEIGHTS.indexOf(count);
    }

    private static int calculatePrizeRank(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        int count = ZERO;

        for(int number : prizeNumbers) {
            if(set.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int calculateBonusNumber(List<Integer> numbers, int count) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.contains(bonusNumber)) {
           return count += SECOND_RANK_WEIGHT;
        }
        return count;
    }
}
