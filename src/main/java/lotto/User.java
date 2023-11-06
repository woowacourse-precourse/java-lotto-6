package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String input(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }
}
