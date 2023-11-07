package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.data.Lotto;
import lotto.message.LottoResult;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoPurchaseManager {
    private final BigDecimal lottoPrice;

    public LottoPurchaseManager(BigDecimal lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public void runPurchase() {
        BigDecimal purchaseAmount = LottoPurchaseInput.inputPurchaseAmount(lottoPrice);

        BigDecimal numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, lottoPrice);
        List<Lotto> lottos = LottoUtil.generateLottos(numberOfLottoPurchased, () -> LottoUtil.generateLotto());
        OutputMessage.printLottos(lottos);

        List<Integer> winningNumbers = LottoPurchaseInput.inputWinningNumbers();
        int bonusNumber = LottoPurchaseInput.inputBonusNumber();

        LottoNumbersInfo lottoNumbersInfo = new LottoNumbersInfo(lottos, winningNumbers, bonusNumber);
        LottoPurchase purchase = new LottoPurchase(purchaseAmount, lottoNumbersInfo);

        HashMap<LottoResult, BigDecimal> result = purchase.getResult();
        float profitRate = purchase.getProfitRate();
        OutputMessage.printWinningStatistics(result, profitRate);
    }
}
