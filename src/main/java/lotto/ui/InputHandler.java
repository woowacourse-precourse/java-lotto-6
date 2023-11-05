package lotto.ui;

public class InputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public InputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public <T> T getValidatedInput(InputSupplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    public interface InputSupplier<T> {
        T get() throws IllegalArgumentException;
    }
}
