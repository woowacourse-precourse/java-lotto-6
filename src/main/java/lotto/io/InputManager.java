package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class InputManager {

    private final InputMapper inputMapper;
    private final InputView inputView;

    public InputManager(final InputMapper inputMapper, final InputView inputView) {
        this.inputMapper = inputMapper;
        this.inputView = inputView;
    }

    public PurchaseAmount readPurchaseAmount() {
        final String input = inputView.readNumber();
        return inputMapper.toPurchaseAmount(input);
    }

    public WinningNumbers readWinningNumbers() {
        final String input = inputView.readWinningNumbers();
        return inputMapper.toWinningNumbers(input);
    }

    public BonusNumber readBonusNumber() {
        final String input = inputView.readNumber();
        return inputMapper.toBonusNumber(input);
    }
}
