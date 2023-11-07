package lotto.controller;

import lotto.core.policy.PickNumberPolicy;
import lotto.core.policy.WinningPolicy;
import lotto.entity.Cost;
import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.tool.OutputGenerateTool;

import static lotto.controller.InputController.inputPurchaseCost;
import static lotto.property.LottoProperty.COST_UNIT_STANDARD;
import static lotto.property.OutputProperty.PURCHASE;
import static lotto.property.OutputProperty.PURCHASE_COUNT;
import static lotto.view.OutputView.outputFormatting;
import static lotto.view.OutputView.outputLineBreak;

public class MainController {

    private final WinningPolicy winningPolicy;

    private final PickNumberPolicy pickNumberPolicy;


    public MainController(WinningPolicy winningPolicy, PickNumberPolicy pickNumberPolicy) {
        this.winningPolicy = winningPolicy;
        this.pickNumberPolicy = pickNumberPolicy;
    }

    public void purchase() {
        outputFormatting(PURCHASE.toString());
        Cost cost = inputPurchaseCost();
        outputLineBreak();
        Long purchaseCount = calculatePurchaseCount(cost);
        outputFormatting(PURCHASE_COUNT.toString().formatted(purchaseCount));
        publishLotto(purchaseCount);
    }

    private void publishLotto(Long purchaseCount) {
        Lottos lottos = new Lottos();
        OutputGenerateTool outputGenerateTool = new OutputGenerateTool();
        for (long i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(pickNumberPolicy.pickUniqueNumbers());
            lottos.publishedLottoCount(lotto);
            outputGenerateTool.generateLottoList(lotto);
        }
        displayPublishedLottos(outputGenerateTool);
    }

    private void displayPublishedLottos(OutputGenerateTool outputGenerateTool) {
        outputFormatting(outputGenerateTool.getLottosFormat());
    }

    private Long calculatePurchaseCount(Cost cost) {
        return cost.getPurchaseCost() / COST_UNIT_STANDARD;
    }
}
