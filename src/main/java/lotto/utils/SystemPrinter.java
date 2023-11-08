package lotto.utils;

public class SystemPrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
