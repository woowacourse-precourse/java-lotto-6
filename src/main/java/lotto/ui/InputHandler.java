package lotto.ui;

public class InputHandler {
    private final OutputView outputView;

    public InputHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T getValidatedInput(InputSupplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (NumberFormatException e) {
                outputView.printError(e.getMessage());
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
