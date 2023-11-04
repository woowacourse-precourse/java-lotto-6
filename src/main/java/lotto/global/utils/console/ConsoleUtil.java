package lotto.global.utils.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void outputRandomList(List<Integer> randomList) {
        System.out.println(randomList);
    }

    public static String input() {
        return Console.readLine();
    }
}
