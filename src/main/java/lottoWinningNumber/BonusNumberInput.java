package lottoWinningNumber;

import static constant.RequestMessage.BONUS_NUMBER_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInput {
    public int getBonusNumber(Converter converter) {
        String bonusNumber = receiveBonusNumber();
        return converter.stringToInteger(bonusNumber);
    }

    private String receiveBonusNumber() {
        printBonusNumberRequestMessage();
        return Console.readLine();
    }

    private void printBonusNumberRequestMessage() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}