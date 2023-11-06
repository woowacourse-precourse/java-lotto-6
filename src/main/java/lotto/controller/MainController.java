package lotto.controller;

import lotto.core.policy.WinningPolicy;
import lotto.entity.Cost;
import lotto.property.LottoProperty;

import static lotto.controller.InputController.inputPurchaseCost;
import static lotto.property.OutputProperty.PURCHASE;
import static lotto.property.OutputProperty.PURCHASE_COUNT;
import static lotto.view.OutputView.outputFormatting;
import static lotto.view.OutputView.outputLineBreak;

public class MainController {

    private final WinningPolicy policy;

    public MainController(WinningPolicy policy) {
        this.policy = policy;
    }

    public void purchase() {
        outputFormatting(PURCHASE.toString());
        Cost cost = inputPurchaseCost();
        outputLineBreak();
        outputFormatting(PURCHASE_COUNT.toString().formatted(calculatePurchaseCount(cost)));
    }

    private Long calculatePurchaseCount(Cost cost) {
        return cost.getPurchaseCost() / LottoProperty.COST_UNIT_STANDARD;
    }
}
