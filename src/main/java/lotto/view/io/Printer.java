package lotto.view.io;

import java.util.List;

public class Printer {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageUsingFormat(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

    public <T> void printListUsingFormat(String format, List<T> argsList) {
        Object[] args = argsList.stream().toArray();
        printMessageUsingFormat(format, args);
    }
}
