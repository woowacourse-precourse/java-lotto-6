package lotto.util.output;

public class ConsolePrinter implements OutputPrinter<Object> {
    @Override
    public void print(Object message) {
        System.out.println(message);
    }
}
