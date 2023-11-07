package lotto.io;

import lotto.view.ConsoleView;
import lotto.view.Prompt;

public class ConsoleUserInterface {

    public static void prompt(Prompt msg) {
        System.out.println(msg);
    }

    public static void printMessage(final String msg) {
        System.out.println(msg);
    }

    public static void printView(ConsoleView view) {
        System.out.println(view.toString());
    }
}
