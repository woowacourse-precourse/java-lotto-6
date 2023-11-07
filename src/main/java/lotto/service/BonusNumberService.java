package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;

public class BonusNumberService extends CreateService {

    public WinningNumber createBonusNumber() {
        Object bonusNumber = this.create();

        return (WinningNumber) bonusNumber;
    }

    @Override
    public Object createObject() {
        String inputBonusNumber = Console.readLine();
        return WinningNumber.createWinningNumber(inputBonusNumber);
    }
}
