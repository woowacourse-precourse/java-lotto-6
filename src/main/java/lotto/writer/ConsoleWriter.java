package lotto.writer;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String context) {
        System.out.println(context);
    }
}
