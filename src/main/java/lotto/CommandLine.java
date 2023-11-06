package lotto;

import camp.nextstep.edu.missionutils.Console;

public class CommandLine {
    public static void showln(String message) {
        System.out.println(message);
    }

    public static void show(String message) {
        System.out.print(message);
    }

    public static String input(String message) {
        show(message);
        return Console.readLine();
    }
}