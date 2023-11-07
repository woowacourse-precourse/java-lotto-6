package lotto.io.reader;

public class ReaderFactory {
    private static final Reader DEFAULT_READER = new ConsoleReader();

    private ReaderFactory() {
    }

    public static Reader getReader() {
        return DEFAULT_READER;
    }
}
