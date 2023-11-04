package lotto.controller;

import lotto.model.Person;
import lotto.model.Shop;
import lotto.model.lotto.LottoHandler;
import lotto.util.Calculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final IOController ioController;
    private Person person;
    private Shop shop;
    private LottoHandler lottoHandler;

    public LottoController() {
        this.ioController = new IOController(new InputView(), new OutputView());
        this.person = Person.of(ioController.purchaseAmountInput());
        this.shop = Shop.of(person.getPurchaseAmout());
    }

    public void process() {
        buyLotto();
        inputNumbers();
        getResults();
    }

    private void buyLotto() {
        ioController.lottoCountCheck(shop.getPurchaseNumber());
        person.buyLotto(shop.giveLottoes());
        ioController.showLotto(person.getLottoesToString());
    }

    private void inputNumbers() {
        this.lottoHandler =
                LottoHandler.of(
                        ioController.winningNumberInput(),
                        ioController.bounusNumberInput()
                );
    }

    private void getResults() {
        lottoHandler.calculateResult(person.getPaperBag());
        ioController.showResult(lottoHandler.resultToString());
        ioController.showRevenue(calculateRevenue());
    }

    private double calculateRevenue() {
        int totalIncome = lottoHandler.getTotalWinAmount();
        int purchasePrice = person.getPurchaseAmout();
        return Calculator.getRevenue(purchasePrice, totalIncome);
    }
}
