package lotto.io;

public class ConsoleOutputStream implements OutputStream {

    @Override
    public void print() {
        System.out.println();
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}