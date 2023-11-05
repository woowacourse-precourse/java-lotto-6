package lotto.io;

public class OutputWriter implements Writer {
    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void writeln(String message) {
        System.out.println();
    }
}
