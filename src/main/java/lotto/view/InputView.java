package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.controller.ErrorCheck;
public class InputView {
    public static String buyLotto() {
        return Console.readLine();
    }
    public static String choiceBonusLottoNum() {
        return Console.readLine();
    }

    public static String choiceMainLottoNum() {
        String choice = Console.readLine();
        ErrorCheck.isSpaceValue(choice);
        return choice;
    }
}
