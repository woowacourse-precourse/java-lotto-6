package lotto.view;

public class InputView {

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }


    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }
}
