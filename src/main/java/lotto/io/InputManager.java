package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

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

    public WinningNumbers readWinningNumbers() {
        return read(
                () -> {
                    final String input = inputView.readWinningNumbers();
                    return inputMapper.toWinningNumbers(input);
                });
    }

    public BonusNumber readBonusNumber() {
        return read(
                () -> {
                    final String input = inputView.readBonusNumber();
                    return inputMapper.toBonusNumber(input);
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
