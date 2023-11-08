package lotto.adapter;

import java.util.List;
import lotto.port.OutputPort;

public class ConsoleOutputAdapter implements OutputPort {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printLine(List<Integer> list) {
        System.out.println(list);
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }

    @Override
    public void printF(String message,double number) {
        System.out.printf(message,number);
    }
}