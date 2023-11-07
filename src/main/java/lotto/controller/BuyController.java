package lotto.controller;

import lotto.model.BoughtLotto;
import lotto.service.InputService;
import lotto.service.OutputService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();

    public int savePrice() {
        String price = inputPrice();
        while (!inputService.priceValidate(price)) {
            price = inputPrice();
        }
        return Integer.parseInt(price);
    }

    private String inputPrice() {
        outputView.inputPriceNoticeOutput();
        return inputView.input();
    }

    public void printBoughtLotto(BoughtLotto boughtLotto) {
        outputView.boughtLottoOutput(boughtLotto.getBoughtNumber(),
                outputService.boughtResult(boughtLotto.getAllLotto()));
    }
}
