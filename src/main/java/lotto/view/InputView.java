package lotto.view;

public class InputView {
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
}
