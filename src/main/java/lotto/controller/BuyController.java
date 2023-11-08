package lotto.controller;

import lotto.model.BoughtLotto;
import lotto.service.OutputService;
import lotto.service.PriceValidateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final OutputService outputService = new OutputService();
    private final PriceValidateService priceValidateService = new PriceValidateService();

    public int savePrice() {
        String price = inputPrice();
        while (!priceValidateService.priceValidate(price)) {
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
