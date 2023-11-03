package lotto.io;

import lotto.domain.LottoPurchasePrice;

import java.util.function.Supplier;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final OutputView outputView = new OutputView();

    public InputManager(InputView inputView, InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public LottoPurchasePrice inputLottoPurchasePrice() {
        return read(() -> {
            String lottoPurchasePrice = inputView.inputLottoPurchasePrice();
            return inputMapper.toLottoPurchasePrice(lottoPurchasePrice);
        });
    }

    private <T> T read(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
