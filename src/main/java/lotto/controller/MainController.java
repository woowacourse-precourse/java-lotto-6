package lotto.controller;

import lotto.core.policy.PickNumberPolicy;
import lotto.core.policy.WinningPolicy;
import lotto.entity.*;
import lotto.tool.OutputGenerateTool;

import java.util.List;

import static lotto.controller.InputController.inputPurchaseCost;
import static lotto.property.LottoProperty.COST_UNIT_STANDARD;
import static lotto.property.OutputProperty.*;
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
        purchaseResult(lottos.getLottos());
    }

    private void displayPublishedLottos(OutputGenerateTool outputGenerateTool) {
        outputFormatting(outputGenerateTool.getLottosFormat());
    }

    private void purchaseResult(List<Lotto> lottos) {
        WeekWinning weekWinning = publishWeekWinning();
        for (int i = 0; i < lottos.size(); i++) {
            winningPolicy.winningCount(lottos.get(i).getNumbers(), weekWinning.winning(), weekWinning.bonus());
        }
    }

    private WeekWinning publishWeekWinning() {
        return new WeekWinning(inputWinning().getWinningNumbers(), inputBonus().getBonusNumber());
    }

    private Winning inputWinning() {
        outputFormatting(INPUT_WINNING.toString());
        return InputController.inputWinningNumbers();
    }

    private Bonus inputBonus() {
        outputFormatting(INPUT_BONUS.toString());
        return InputController.inputBonusNumber();
    }

    private Long calculatePurchaseCount(Cost cost) {
        return cost.getPurchaseCost() / COST_UNIT_STANDARD;
    }
}
