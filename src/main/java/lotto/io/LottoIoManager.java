package lotto.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchasePrice;

import java.util.function.Supplier;

public class LottoIoManager implements IoManager {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final OutputView outputView;

    public LottoIoManager(InputView inputView, InputMapper inputMapper, OutputView outputView) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
        this.outputView = outputView;
    }

    @Override
    public PurchasePrice inputPurchasePrice() {
        return read(() -> {
            outputView.printPurchasePriceMessage();
            String purchasePrice = inputView.inputPurchasePrice();
            return inputMapper.toPurchasePrice(purchasePrice);
        });
    }

    @Override
    public Lotto inputLotto() {
        return read(() -> {
            outputView.printWinningNumbersMessage();
            String lotto = inputView.inputLotto();
            return inputMapper.toLotto(lotto);
        });
    }

    @Override
    public BonusNumber inputBonusNumber(Lotto lotto) {
        return read(() -> {
            outputView.printBonusNumberMessage();
            String bonusNUmber = inputView.inputBonusNumber();
            return inputMapper.toBonusNumber(bonusNUmber, lotto);
        });
    }

    @Override
    public <T> T read(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
