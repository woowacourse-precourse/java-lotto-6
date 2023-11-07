package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.StringConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class GameService {

    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;
    private Lotteries lotteries;
    private LottoResult lottoResult;

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createWinningLotto(String winningNumber, String userBonusNumber) {
        Lotto lotto = new Lotto(convertStrToList(winningNumber));
        BonusNumber bonusNumber = BonusNumber.of(userBonusNumber, lotto);
        winningLotto = WinningLotto.of(lotto, bonusNumber);
    }

    public void createLotteries() {
        lotteries = Lotteries.from(purchaseAmount.calculateAmountOfLotteries());
    }

    public void createLottoResult() {
        lottoResult = LottoResult.from();
        lottoResult.countWinningCase(lotteries.getLotteries(), winningLotto);
    }

    public List<List<Integer>> printLottoNumbers() {
        return lotteries.getNumbersOfLotteries();
    }

    public int printPurchaseAmount() {
        return purchaseAmount.calculateAmountOfLotteries();
    }

    public Map<String, Integer> printGameResult() {
        return lottoResult.getResultMap();
    }

    public double printEarningRate() {
        return lottoResult.calculateEarningRate(purchaseAmount.getTotalPrice());
    }

    private List<Integer> convertStrToList(String winningLotto) {
        return Arrays.stream(winningLotto.split(StringConstant.DIVISION_STANDARD.getMessage()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
