package lotto.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int NUMBER_MIN =1;
    public static final int NUMBER_MAX =45;
    public static final int NUMBER_QUANTITY =6;
    public boolean hasDubplicatesUserNumbers(List<Integer> winningNumbers){
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != winningNumbers.size();
    }
    public boolean isValidRange(List<Integer> winningNumbers){
        for (int number : winningNumbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) return false;
        }
        return true;
    }
    public static boolean isValidLength(List<Integer> numbers) {
        return numbers.size() == NUMBER_QUANTITY;
    }
    public boolean isValidRangeBonusNumber(int BonusNumber){
        if (BonusNumber < NUMBER_MIN || BonusNumber > NUMBER_MAX) return false;
        return true;
    }
}
