package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumbers;
import lotto.message.LottoPrize;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoSeller {
    public final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    public void run() {
        BigDecimal purchaseAmount = LottoPurchaseInput.inputPurchaseAmount(lottoPrice);

        BigDecimal numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, lottoPrice);
        List<Lotto> lottos = LottoUtil.generateLottos(numberOfLottoPurchased, () -> LottoUtil.generateLotto());
        OutputMessage.printLottos(lottos);

        WinningNumbers winningNumbers = LottoPurchaseInput.inputWinningNumbers();

        HashMap<LottoPrize, BigDecimal> lottoRank = winningNumbers.getResultWith(lottos);
        LottoResult lottoResult = new LottoResult(lottoRank, purchaseAmount);
        OutputMessage.printWinningStatistics(lottoResult);
    }
}
