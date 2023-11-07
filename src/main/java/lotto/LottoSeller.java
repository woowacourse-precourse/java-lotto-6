package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.data.Amount;
import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningCombination;
import lotto.domain.LottoPurchaseInput;
import lotto.message.LottoPrize;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoSeller {
    public final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    public void run() {
        Amount purchaseAmount = LottoPurchaseInput.inputPurchaseAmount(lottoPrice);

        BigDecimal numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, lottoPrice);
        List<Lotto> lottos = LottoUtil.generateLottos(numberOfLottoPurchased, () -> LottoUtil.generateLotto());
        OutputMessage.printLottos(lottos);

        List<Integer> winningNumbers = LottoPurchaseInput.inputWinningNumbers();
        WinningCombination winningCombination = LottoPurchaseInput.inputBonusNumber(winningNumbers);

        Map<LottoPrize, BigDecimal> lottoRank = winningCombination.getResultWith(lottos);
        LottoResult lottoResult = new LottoResult(lottoRank, purchaseAmount);
        OutputMessage.printWinningStatistics(lottoResult);
    }
}
