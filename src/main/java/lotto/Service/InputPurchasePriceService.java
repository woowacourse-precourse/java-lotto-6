package lotto.Service;

import lotto.model.PurchasePrice;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class InputPurchasePriceService {
    private final InputView inputView;
    private final OutputView outputView;

    public InputPurchasePriceService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public PurchasePrice inputPurchasePrice() {
        while (true) {
            try {
                outputView.printInputPurchasePrice();
                return new PurchasePrice(inputView.inputPurchasePrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
