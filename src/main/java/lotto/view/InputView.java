package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readString(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
