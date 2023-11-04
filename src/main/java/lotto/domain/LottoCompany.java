package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.NumberValidator;

public enum LottoCompany {
    INSTANCE;
    private static final int ZERO = 0;
    private static final int THIRD_RANK = 5;
    private static final int SECOND_RANK_WEIGHT = 10;
    private static final int PRIZE_RANK_MAX = 5;
    private static final List<Integer> PRIZE_RANK_NUMBERS = List.of(3, 4, 5, 15, 6);
    private static List<Integer> prizeNumbers = new ArrayList<Integer>();
    private static int bonusNumber;

    public static void setPrizeNumbers(List<Integer> prizeNumbers) {
        NumberValidator.validateLottoNumbers(prizeNumbers);
        LottoCompany.prizeNumbers = prizeNumbers;
    }

    public static void setBonusNumber(int bonusNumber) {
        NumberValidator.isValidRange(bonusNumber);
        NumberValidator.checkDuplicates(bonusNumber);
        LottoCompany.bonusNumber = bonusNumber;
    }

    public static int matchPrize(List<Integer> numbers) {
        int count = calculatePrizeRank(numbers);
        if(count == THIRD_RANK) {
            count = calculateBonusNumber(numbers, count);
        }

        return PRIZE_RANK_NUMBERS.indexOf(count);
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
