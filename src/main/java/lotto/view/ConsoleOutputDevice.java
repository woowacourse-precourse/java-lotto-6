package lotto.view;

public class ConsoleOutputDevice implements OutputDevice {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printByFormat(String format, Object... args) {
        System.out.printf(format, args);
    }
}
