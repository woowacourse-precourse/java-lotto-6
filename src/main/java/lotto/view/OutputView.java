package lotto.view;

public interface OutputView {

    void print(String message);

    void print(PrintMessage message);

    void print(PrintMessage message, Object... arsg);

}
