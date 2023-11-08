package lotto.view;


public class ConsoleOutputView implements OutputView{
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(PrintMessage message) {
        print(message.getMessage());
    }

    @Override
    public void print(PrintMessage message, Object... args) {
        System.out.println(String.format(message.getMessage(), args));
    }
}
