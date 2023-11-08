package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.data.Amount;
import lotto.data.Lotto;
import lotto.data.WinningCombination;
import lotto.domain.LottoResult;
import lotto.io.LottoPurchaseInput;
import lotto.io.LottoPurchaseOutput;
import lotto.data.LottoPrize;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoSeller {
    public final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    public void run() {
        Amount purchaseAmount = LottoPurchaseInput.inputPurchaseAmount(lottoPrice);

        BigDecimal numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, lottoPrice);
        List<Lotto> lottos = LottoUtil.generateLottos(numberOfLottoPurchased, () -> LottoUtil.generateLotto());
        LottoPurchaseOutput.printLottos(lottos);

        List<Integer> winningNumbers = LottoPurchaseInput.inputWinningNumbers();
        WinningCombination winningCombination = LottoPurchaseInput.inputBonusNumber(winningNumbers);

        Map<LottoPrize, BigDecimal> lottoRank = winningCombination.getResultWith(lottos);
        LottoResult lottoResult = new LottoResult(lottoRank, purchaseAmount);
        LottoPurchaseOutput.printWinningStatistics(lottoResult);
    }
}
