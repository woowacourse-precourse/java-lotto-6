package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class GameService {

    private final String DIVISION_STANDARD = ",";

    private PurchaseAmount purchaseAmount;
    private Lotteries lotteries;
    private Lotto winningNumbers;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;
    private final NumberGenerator numberGenerator;

    public GameService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createLotteries() {
        int purchaseCount = purchaseAmount.calculateAmountOfLotteries();
        lotteries = Lotteries.of(purchaseCount, numberGenerator);
    }

    public void createWinningNumbers(String winningNumber) {
        winningNumbers = new Lotto(convertStrToList(winningNumber));
    }

    public void createWinningLotto(String userBonusNumber) {
        BonusNumber bonusNumber = BonusNumber.of(userBonusNumber, winningNumbers);
        winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
    }

    public void createLottoResult() {
        lottoResult = LottoResult.from();
        lottoResult.countWinningCase(lotteries.getLotteries(), winningLotto);
    }

    public Lotteries printLottoNumbers() {
        return lotteries;
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
        return Arrays.stream(winningLotto.split(DIVISION_STANDARD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
