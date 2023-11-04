package lotto.io.output;

public class Writer implements StdWriter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }
}
