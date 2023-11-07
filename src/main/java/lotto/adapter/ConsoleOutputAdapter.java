package lotto.adapter;

import lotto.port.OutputPort;

public class ConsoleOutputAdapter implements OutputPort {
    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

}