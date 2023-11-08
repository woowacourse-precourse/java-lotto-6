package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.constant.IOMessage;

public class InputView {

    public String getInputMoney() {
        System.out.println(IOMessage.INPUT_MONEY_MESSAGE);
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public String getInputLottoNumbers() {
        System.out.println(IOMessage.INPUT_LOTTO_NUMBERS_MESSAGE);
        String inputLottoNumbers = Console.readLine();
        return inputLottoNumbers;
    }
}
