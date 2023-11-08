package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;

public class BonusNumberService extends CreateService {

    public BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        Object bonusNumber = this.create(winningNumbers);

        return (BonusNumber) bonusNumber;
    }

    @Override
    public Object createObject(Object... input) {
        String inputBonusNumber = Console.readLine();
        WinningNumber winningNumber = WinningNumber.createWinningNumber(inputBonusNumber);
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(winningNumber, (WinningNumbers) input[0]);

        return bonusNumber;
    }
}
