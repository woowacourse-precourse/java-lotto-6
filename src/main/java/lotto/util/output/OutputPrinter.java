package lotto.util.output;

@FunctionalInterface
public interface OutputPrinter<T> {
    void print(Object message);
}
