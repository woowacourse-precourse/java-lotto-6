package lotto.view.output;

public class ConsoleOutput implements Output{

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }
}
