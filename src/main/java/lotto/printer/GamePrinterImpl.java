package lotto.printer;

public class GamePrinterImpl implements GamePrinter {

    @Override
    public void print(Object obj) {
        System.out.println(obj);
    }

    @Override
    public void print(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
