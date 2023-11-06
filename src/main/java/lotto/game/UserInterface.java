package lotto.game;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    public static void printOut(String message) {
        System.out.println(message);
    }

    public static String printIn() {
        return Console.readLine();
    }
}
