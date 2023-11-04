package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.Instructions;

public class UI {

    public static String inputLottoAmount() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_LOTTO_AMOUNT);
        String lottoAmountInputValue  = Console.readLine();
        //TODO - 입력 검증 추가
        return lottoAmountInputValue;
    }

    public static void displayMessage(final Instructions instructions) {
        System.out.println(instructions.getPrompts());
    }

}
