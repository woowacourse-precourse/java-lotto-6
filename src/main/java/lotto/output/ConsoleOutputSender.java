package lotto.output;

public class ConsoleOutputSender implements OutputSender {

    @Override
    public void send(String output) {
        System.out.println(output);
    }
}
