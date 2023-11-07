package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateSystem {

    public void validatePaymentAccount(int paymentAccount){
        if (paymentAccount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]: 1,000단위의 금액으로 입력해주세요.");
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers){

        if(winningNumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR]: 6개의 숫자를 입력해야합니다.");
        }

        Set<Integer> setNumbers = new HashSet<>(winningNumbers);
        if(setNumbers.size()!= winningNumbers.size()){
            throw new IllegalArgumentException("[ERROR]: 중복된 숫자가 있습니다.");
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.intValue() < 1 || winningNumber.intValue() > 45) {
                throw new IllegalArgumentException("[ERROR]: 1~45사이의 숫자만 입력해주세요.");
            }
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
