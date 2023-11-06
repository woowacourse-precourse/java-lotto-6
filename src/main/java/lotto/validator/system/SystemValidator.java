package lotto.validator.system;

import lotto.domain.WinningLottoNumbers;
import lotto.view.message.exception.BudgetInputErrorMessage;
import lotto.view.message.exception.LottoGenerateErrorMessage;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SystemValidator {
    private static final int LOTTO_MAX_NUMBER =45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int MINIMUM_BUDGET = 1000;
    private static final int LOTTO_SIZE =6;
    private static final int BUDGET_MINIMUM_UNIT = 1000;

    public static void budgetValidator(int budget){
        if(isNotDivisibleByThousand(budget)){
            throw new IllegalArgumentException(BudgetInputErrorMessage.DIVISIBLE_BY_THOUSAND.getMessage());
        }
        if(isLessThanMinimumBudget(budget)){
            throw new IllegalArgumentException(BudgetInputErrorMessage.LESS_THAN_1000.getMessage());
        }
    }

    private static boolean isNotDivisibleByThousand(int budget){
        if(budget%BUDGET_MINIMUM_UNIT!=0){
            return true;
        }
        return false;
    }

    public static void lottoValidator(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.INCORRECT_SIZE.getMessage());
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void winningNumbersValidator(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.INCORRECT_SIZE.getMessage());
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
    public static void winningCombinationValidator(WinningLottoNumbers winningLottoNumbers, int bonusNumber){
        if(isOutOfRangeBonusNumber(bonusNumber)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicateBonusNumber(winningLottoNumbers,bonusNumber)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static boolean isSizeWrong(List<Integer> numbers){
        if(numbers.size()!=LOTTO_SIZE){
            return true;
        }
        return false;
    }

    private static boolean isDuplicateBonusNumber(WinningLottoNumbers winningLottoNumbers,int bonusNumber){
        List<Integer> winningNumbers = winningLottoNumbers.getNumbers();
        if(winningNumbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    private static boolean isOutOfRangeBonusNumber(int bonusNumber){
        return isOutOfRange(bonusNumber);
    }

    private static boolean isLessThanMinimumBudget(int budget){
        return budget<MINIMUM_BUDGET;
    }

    private static boolean isDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            // 중복된 숫자가 있음
            return true;
        }
        return false;
    }

    private static boolean isOutOfRangeLottoNumbers(List<Integer> numbers){
        for(int lottoNumber : numbers){
            if(isOutOfRange(lottoNumber)){
                return true;
            }
        }
        return false;
    }

    private static boolean isOutOfRange(int number){
        return number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER;
    }
}
