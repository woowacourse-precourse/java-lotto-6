package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney(){
        OutputView.inputMessage();
        return Console.readLine();
    }
}
