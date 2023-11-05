package lotto.util.Printer;

public class Printer implements IPrinter {

    @Override
    public void println(String string) {
        System.out.println(string);
    }

    @Override
    public void println() {
        System.out.println();
    }

}
