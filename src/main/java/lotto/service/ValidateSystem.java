package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateSystem {

    public void validatePaymentAccount(int paymentAccount){
        if (paymentAccount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers){

        if(winningNumbers.size()!=6){
            throw new IllegalArgumentException();
        }

        Set<Integer> setNumbers = new HashSet<>(winningNumbers);
        if(setNumbers.size()!= winningNumbers.size()){
            throw new IllegalArgumentException();
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.intValue() < 1 || winningNumber.intValue() > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
