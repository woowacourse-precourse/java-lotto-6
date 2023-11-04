package lotto.io;

import lotto.domain.Amount;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(final InputView inputView, final InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public Amount readPurchaseAmount() {
        final String input = inputView.readPurchaseAmount();
        return inputMapper.toAmount(input);
    }
}
