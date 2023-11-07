package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public int inputTryNum() {
        int tryNum;
        String tryNumString = Console.readLine();

        tryNum = Integer.parseInt(tryNumString);

        return tryNum;
    }
}
