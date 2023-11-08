package View;

import Controller.ModelHandler;
import Model.Lotto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private ModelHandler moder = ModelHandler.getInstance();

    public void printMyLotto() {
        moder.printMyLotto();
    }

    public void printStatistics() {
        moder.printStatistics();
    }
}
