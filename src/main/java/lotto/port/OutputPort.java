package lotto.port;

import java.util.List;

public interface OutputPort {
    void printLine(String message);
    void printLine(List<Integer> list);
    void printEmptyLine();
    void printF(String message, double number);
}
