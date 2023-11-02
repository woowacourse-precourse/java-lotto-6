package lotto.io;

import lotto.domain.PurchaseAmount;

import java.util.function.Supplier;

public class InputManager {

    private final InputMapper inputMapper;
    private final InputView inputView;

    public InputManager(final InputMapper inputMapper, final InputView inputView) {
        this.inputMapper = inputMapper;
        this.inputView = inputView;
    }

    public PurchaseAmount readPurchaseAmount() {
        return read(
                () -> {
                    final String input = inputView.readPurchaseAmount();
                    return inputMapper.toPurchaseAmount(input);
                });
    }

    private <T> T read(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
