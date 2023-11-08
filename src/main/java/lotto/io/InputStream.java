package lotto.io;

public interface InputStream {
    String inputLine();

    int inputInt() throws IllegalArgumentException;
}