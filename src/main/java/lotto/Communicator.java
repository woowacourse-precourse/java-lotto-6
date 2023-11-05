package lotto;

public class Communicator {
    private static final Printer DEFAULT_PRINTER = new ConsolePrinter();

    private final Printer printer;

    public Communicator() {
        this(DEFAULT_PRINTER);
    }

    public Communicator(Printer printer) {
        this.printer = printer;
    }

    public void printStart() {
        printer.print("구입금액을 입력해주세요.");
    }
}
