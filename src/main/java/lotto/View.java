package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String getUserInput() {
        return Console.readLine();
    }

    public static void printMessage(Notice notice) {
        System.out.println(notice.getMessage());
    }
}
