package Controller;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class MoneyInputController {
    InputView view;

    public Integer getMoneyByConsole(){
        view.introduceMoneyInput();
        String str = Console.readLine();

    }
}
