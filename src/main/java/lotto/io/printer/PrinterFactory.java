package lotto.io.printer;

public class PrinterFactory {
    private static final Printer DEFAULT_PRINTER = new ConsolePrinter();

    private PrinterFactory() {
    }

    public static Printer getPrinter() {
        return DEFAULT_PRINTER;
    }
}
