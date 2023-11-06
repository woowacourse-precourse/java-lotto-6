package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.util.mapper.DtoModelMapper;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
    }

    private PurchaseAmount getValidPurchaseAmount() {
        while (true) {
            try {
                return DtoModelMapper.dtoToPurchaseAmount(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
