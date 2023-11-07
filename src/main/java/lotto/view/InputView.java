package lotto.view;

import java.util.List;

public interface InputView {
    int readIntegerInput();
    List<Integer> readWinningLotto();
    void close();
}
