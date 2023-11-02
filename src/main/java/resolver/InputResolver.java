package resolver;

import view.InputView;

public class InputResolver {
    private final InputView inputView;

    public InputResolver(InputView inputView) {
        this.inputView = inputView;
    }

    public int preprocessLottoPurchasePrice() {
        String inputLottoPurchasePrice = inputView.inputLottoPurchasePrice();
        return convertStringToInt(inputLottoPurchasePrice);
    }
    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 숫자로 입력해야합니다.");
            throw new IllegalArgumentException("숫자로 입력해야합니다.", e);
        }
    }
}
