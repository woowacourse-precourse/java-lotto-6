package lotto.view.input;

public class InputView {
    private InputView() {
    }

    public static int readLottoPurchasePrice() {
        Input input = Input.readLine();

        IntegerInput integerInput = new IntegerInput(input.trimmed());
        return integerInput.value();
    }
}
