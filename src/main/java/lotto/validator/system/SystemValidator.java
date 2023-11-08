package lotto.validator.system;

import lotto.domain.WinningLottoNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SystemValidator {
    private static final int LOTTO_MAX_NUMBER =45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int MINIMUM_BUDGET = 1000;
    private static final int LOTTO_SIZE =6;
    private static final int BUDGET_MINIMUM_UNIT = 1000;

    protected static boolean isNotDivisibleByThousand(int budget){
        return budget % BUDGET_MINIMUM_UNIT != 0;
    }

    protected static boolean isSizeWrong(List<Integer> numbers){
        return numbers.size() != LOTTO_SIZE;
    }

    protected static boolean isDuplicateBonusNumber(WinningLottoNumbers winningLottoNumbers,int bonusNumber){
        List<Integer> winningNumbers = winningLottoNumbers.getNumbers();
        return winningNumbers.contains(bonusNumber);
    }

    protected static boolean isOutOfRangeBonusNumber(int bonusNumber){
        return isOutOfRange(bonusNumber);
    }

    protected static boolean isLessThanMinimumBudget(int budget){
        return budget<MINIMUM_BUDGET;
    }

    protected static boolean isDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        // 중복된 숫자가 있음
        return set.size() < numbers.size();
    }

    protected static boolean isOutOfRangeLottoNumbers(List<Integer> numbers){
        for(int lottoNumber : numbers){
            if(isOutOfRange(lottoNumber)){
                return true;
            }
        }
        return false;
    }

    protected static boolean isOutOfRange(int number){
        return number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER;
    }
}
