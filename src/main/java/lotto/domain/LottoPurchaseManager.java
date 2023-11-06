package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.message.LottoResult;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoPurchaseManager {
    public void runPurchase() {
        BigDecimal purchaseAmount = LottoPurchaseInput.inputPurchaseAmount();

        BigDecimal numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, Lotto.PRICE);
        List<Lotto> lottos = LottoUtil.generateLottos(numberOfLottoPurchased, () -> LottoUtil.generateLotto());
        OutputMessage.printLottos(lottos);

        List<Integer> winningNumbers = LottoPurchaseInput.inputWinningNumbers();
        int bonusNumber = LottoPurchaseInput.inputBonusNumber();

        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, Lotto.PRICE);
        LottoNumbersInfo lottoNumbersInfo = new LottoNumbersInfo(lottos, winningNumbers, bonusNumber);
        LottoPurchase purchase = new LottoPurchase(lottoPurchaseInfo, lottoNumbersInfo);

        HashMap<LottoResult, BigDecimal> result = purchase.getResult();
        float profitRate = purchase.getProfitRate();
        OutputMessage.printWinningStatistics(result, profitRate);
    }
}
