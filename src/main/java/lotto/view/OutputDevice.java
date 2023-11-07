package lotto.view;

public class OutputDevice implements Writable {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printByFormat(String format, Object... args) {
        System.out.printf(format, args);
    }
}
