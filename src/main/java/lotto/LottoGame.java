package lotto;

import lotto.UI.LottoUI;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.service.LottoEvaluator;
import lotto.service.LottoPurchaseService;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoUI ui = new LottoUI();
    private final LottoPurchaseService purchaseService = new LottoPurchaseService();
    private final LottoEvaluator evaluator = new LottoEvaluator();

    public void start() {
        int purchaseAmount = ui.inputPurchaseAmount();
        List<Lotto> lottos = purchaseService.purchaseLotto(purchaseAmount);
        ui.displayPurchasedLottos(lottos);

        WinningNumbers winningNumbers = ui.inputWinningNumbers();
        Map<Prize, Integer> results = evaluator.evaluate(lottos, winningNumbers);
        LottoResult lottoResult = new LottoResult(results, purchaseAmount);
        ui.displayResults(lottoResult);
    }
}