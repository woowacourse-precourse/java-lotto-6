package lotto.controller;

import lotto.core.policy.PickNumberPolicy;
import lotto.core.policy.WinningPolicy;
import lotto.entity.*;
import lotto.property.MethodProperty;
import lotto.tool.OutputGenerateTool;

import java.util.List;
import java.util.Map;

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
        publishLotto(purchaseCount, cost);
    }

    private void publishLotto(Long purchaseCount, Cost cost) {
        Lottos lottos = new Lottos();
        OutputGenerateTool outputGenerateTool = new OutputGenerateTool();
        for (long i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(pickNumberPolicy.pickUniqueNumbers());
            lottos.publishedLottoCount(lotto);
            outputGenerateTool.generateLottoList(lotto);
        }
        displayPublishedLottos(outputGenerateTool);
        purchaseResult(lottos.getLottos(), cost);
    }

    private void displayPublishedLottos(OutputGenerateTool outputGenerateTool) {
        outputFormatting(outputGenerateTool.getLottosFormat(MethodProperty.LOTTOS_FORMAT));
    }

    private void purchaseResult(List<Lotto> lottos, Cost cost) {
        WeekWinning weekWinning = publishWeekWinning();
        LottoManager lottoManager = new LottoManager();
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getNumbers();
            lottoManager.purchasedLottosResult(
                    winningPolicy.winningCount(lottoNumbers, weekWinning.winning()),
                    winningPolicy.hitBonus(lottoNumbers, weekWinning.bonus())
            );
        }
        writePurchaseResult(lottoManager.getResultEnumMap(), lottoManager.calculateLottoRate(cost));
    }

    private void writePurchaseResult(Map<LottoResult, Integer> lottoResultMap, String lottoRate) {
        OutputGenerateTool outputGenerateTool = new OutputGenerateTool();
        for (LottoResult lottoResult : lottoResultMap.keySet()) {
            if (lottoResult.equals(LottoResult.NO_PRIZE)) continue;
            outputGenerateTool.generateLottoResult(lottoResult, lottoResultMap.get(lottoResult));
        }
        displayLottoResult(outputGenerateTool);
        displayLottoRate(lottoRate);
    }

    private void displayLottoResult(OutputGenerateTool outputGenerateTool) {
        outputFormatting(LOTTO_RESULT.toString());
        outputFormatting(outputGenerateTool.getLottosFormat(MethodProperty.LOTTO_RESULT_FORMAT));
    }

    private void displayLottoRate(String lottoRate) {
        outputFormatting(LOTTO_RATE_PREFIX + lottoRate + LOTTO_RATE_SUFFIX);
    }

    private WeekWinning publishWeekWinning() {
        Winning winning = inputWinning();
        outputLineBreak();
        Bonus bonus = inputBonus();
        outputLineBreak();
        return new WeekWinning(winning.getWinningNumbers(), bonus.getBonusNumber());
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
