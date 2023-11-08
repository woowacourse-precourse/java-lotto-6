package lotto.model;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final String regex ="^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^[4]{1}[0-5]{1}$";

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateListSize(winningNumbers);
        validateDuplicateNumber(winningNumbers,bonusNumber);
        validateRangeNumber(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
    public boolean validateListSize(List<Integer> winningNumbers) throws IllegalArgumentException{
        if(winningNumbers.size()==6) return true;
        throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_COUNT.getMessage());
    }
    public boolean validateDuplicateNumber(List<Integer> winningNumbers,int bonusNumber){
        Set<Integer> check = new HashSet<>();
        for(int number : winningNumbers){
            if(check.contains(number)) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            check.add(number);
        }
        if (check.contains(bonusNumber)) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_AND_BONUS_NUMBER.getMessage());
        return true;
    }
    public boolean validateRangeNumber(List<Integer> winningNumbers){
        for(int number : winningNumbers){
            if(!String.valueOf(number).matches(regex)) throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
        }
        return true;
    }
    public boolean validateBonusNumber(int bonusNumber){
        if(!String.valueOf(bonusNumber).matches(regex)) throw new IllegalArgumentException(ErrorMessage.INCORRECT_BONUS_NUMBER.getMessage());
        return true;
    }
}
