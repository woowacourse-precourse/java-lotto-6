package lotto.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int NUMBER_MIN =1;
    public static final int NUMBER_MAX =45;
    public static final int NUMBER_QUANTITY =6;
    List<Integer>validatorWinningNumbers;
    public void validateLottoNumber(List<Integer> winningNumbers) {
        validatorWinningNumbers=winningNumbers;
        if(!isValidLength(winningNumbers)){
            System.out.println("[ERROR] 로또 번호는 6자리 숫자로 이루어져야 합니다.");
            throw new IllegalArgumentException("로또 번호는 6자리 숫자로 이루어져야 합니다.");
        }if(hasDuplicateUserNumbers(winningNumbers)){
            System.out.println("[ERROR] 중복되는 로또 번호가 있습니다.");
            throw new IllegalArgumentException("중복되는 당첨 번호가 있습니다.");
        }if(!isValidRange(winningNumbers)){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private boolean hasDuplicateUserNumbers(List<Integer> winningNumbers){
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != winningNumbers.size();
    }
    private boolean isValidRange(List<Integer> winningNumbers){
        for (int number : winningNumbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) return false;
        }
        return true;
    }
    public static boolean isValidLength(List<Integer> numbers) {
        return numbers.size() == NUMBER_QUANTITY;
    }
    public void validateBonusNumber(int bonusBall) {
        if(!isValidRangeBonusNumber(bonusBall)){
            System.out.println("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if(hasDuplicateBonusNumber(bonusBall)){
            System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
    private boolean isValidRangeBonusNumber(int bonusNumber){
        if (bonusNumber < NUMBER_MIN || bonusNumber > NUMBER_MAX) return false;
        return true;
    }

    private boolean hasDuplicateBonusNumber(int bonusNumber) {
        for(Integer winningNumber:validatorWinningNumbers){
            if(winningNumber==bonusNumber) return true;
        }
        return false;
    }
}
