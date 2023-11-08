package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private final int pricePerLotto = 1000;
    private final int lottoNumberCount = 6;
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;

    private User user;
    private Result result;
    private Calculation calculation;

    public LottoManager() {
        this.user = new User();
        this.result = new Result();
        this.calculation = new Calculation();
    }

    public void launch() {
        int purchaseAmount = user.inputValidatedPurchaseAmount(this);
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        result.printNumberOfLottosPurchased(purchasedLottos.size());
        result.printPurchasedLottos(purchasedLottos);
        List<Integer> winningNumbers = user.inputValidatedWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        WinningNumber winningNumber = user.inputValidatedBonusNumber(winningLotto);
        Map<Rank, Integer> statistics = calculation.calculateAllRankCounts(purchasedLottos, winningNumber);
        result.printStatistics(statistics);
        double profitRate = calculation.calculateProfitRate(statistics, purchaseAmount);
        result.printProfitRate(profitRate);
    }

    public boolean verifyPurchaseAmount(int purchaseAmount) {
        return isValidPurchaseAmount(purchaseAmount);
    }
    private boolean isValidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % pricePerLotto == 0;
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / pricePerLotto;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoNumberCount);
        return new Lotto(numbers);
    }

}
