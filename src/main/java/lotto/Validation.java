package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public void isPaymentDivided(int payment){
        if(payment % 1000 != 0){
            throw new IllegalArgumentException(Progress.ERROR_THOUSAND.getMessage());
        }
    }

    public boolean isCorrectDomainValue(int from, int to, int toCheck){
        if(toCheck > to || toCheck < from){
            return false;
        }
        return true;
    }

    public boolean isDuplicate(List<Integer> numSet, int toCheck){
        return !numSet.contains(toCheck);
    }

    public void isDuplicateExistDataSet(List<Integer> numSet){
        Set<Integer> set = new HashSet<>(numSet);
        if(set.size() != numSet.size()){
            throw new IllegalArgumentException(Progress.ERROR_DUPLICATE.getMessage());
        }
    }

    public void isWinningValidate(List<Integer> numSet, int toCheck){
        if(!isCorrectDomainValue(1,45,toCheck)){
            throw new IllegalArgumentException(Progress.ERROR_DOMAIN.getMessage());
        }
        if(!isDuplicate(numSet,toCheck)){
            throw new IllegalArgumentException(Progress.ERROR_DUPLICATE.getMessage());
        }
    }

    public void isWinningSetValidate(List<Integer> numSet){
        if(numSet.size() != 6){
            throw new IllegalArgumentException(Progress.ERROR_LOTTO_SIZE.getMessage());
        }
    }

    public void isBonusValidate(List<Integer> numSet, int toCheck){
        if(!isCorrectDomainValue(1,45,toCheck)){
            throw new IllegalArgumentException(Progress.ERROR_DOMAIN.getMessage());
        }
        if(!isDuplicate(numSet,toCheck)){
            throw new IllegalArgumentException(Progress.ERROR_BONUS_DUPLICATE.getMessage());
        }
    }
}
