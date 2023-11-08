package lotto;

import java.util.List;

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
