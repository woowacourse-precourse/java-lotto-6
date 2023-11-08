package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.utils.ErrorMessage;

public class BonusNumberService extends CreateService {

    public WinningNumber createBonusNumber(WinningNumbers winningNumbers) {
        Object bonusNumber = this.create(winningNumbers);

        return (WinningNumber) bonusNumber;
    }

    @Override
    public Object createObject(Object... input) {
        String inputBonusNumber = Console.readLine();
        WinningNumber bonusNumber = WinningNumber.createWinningNumber(inputBonusNumber);

        validateDuplication((WinningNumbers) input[0], bonusNumber);
        return bonusNumber;
    }

    private void validateDuplication(WinningNumbers winningNumbers, WinningNumber bonusNumber){
        if(winningNumbers.isNumberExist(bonusNumber)){
           throw new IllegalArgumentException(ErrorMessage.DUPLICATED_VALUES.getErrorMessage());
        }
    }
}
