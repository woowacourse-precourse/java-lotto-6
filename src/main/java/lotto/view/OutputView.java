package lotto.view;

public class OutputView {
    public static OutputView getInstance() {

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private void println(String output) {
        System.out.println(output);
    }
}
