package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static InputView instance;


    private InputView() {
    }


    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String inputMoney() {
        return Console.readLine();
    }

    public String inputWinnerNumbers() {
        return Console.readLine();
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}
