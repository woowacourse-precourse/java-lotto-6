package lotto.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.Result;
import lotto.LottoGenerator;
import lotto.Util.Validation;
import lotto.View.InputView;


public class LottoController {

    private static final int LOTTO_PRICE_PER_GAME = 1000;
    private static final int HIT_TICK = 1;
    private static final String SEPERATOR = ",";
    private static final String NO_SPACE = "";
    private int purchasedAmount = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winnerLotto;
    private int bonusNumber;

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void setWinnerLotto(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    private int calcAvailableAmount(int availableMoney) {
        return availableMoney / LOTTO_PRICE_PER_GAME;
    }

    private void purchaseLotto() {
        int availableMoney = InputView.getAvailableMoney();
        this.purchasedAmount = calcAvailableAmount(availableMoney);
    }

    private void publishLotto() {
        for (int i = 0; i < this.purchasedAmount; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generateRandomLotto();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    private void getWinnerLotto() {
        List<Integer> numbers = InputView.getLottoNumbers();
        setWinnerLotto(new Lotto(numbers));

        int bonusNumber = InputView.getBonusNumber(numbers);
        setBonusNumber(bonusNumber);
    }

    private int[] compareWinnerAndPurchased(Lotto lotto) {
        int normalHitCount = 0;
        int bonusHitCount = 0;

        for (Integer number : lotto.getNumbers()) {
            if (this.winnerLotto.getNumbers().contains(number)) {
                normalHitCount += HIT_TICK;
            }
            if (this.bonusNumber == number) {
                bonusHitCount += HIT_TICK;
            }
        }

        return new int[]{normalHitCount, bonusHitCount};
    }

    private Map<String, Integer> setDefaultResult(Map<String, Integer> results) {
        for (Result result : Result.values()) {
            results.put(result.name(), 0);
        }

        return results;
    }

    private Map<String, Integer> makeResults(Map<String, Integer> results,
                                             int normalHitCount, int bonusHitCount) {
        for (Result result : Result.values()) {
            if (normalHitCount == 5 && bonusHitCount == 1
                    && result.getHitCount() == normalHitCount) {
                results.put(result.name(), results.get(result.name()) + 1);
                break;
            }

            if (normalHitCount == result.getHitCount()) {
                results.put(result.name(), results.get(result.name()) + 1);
            }
        }

        return results;
    }

    private Map<String, Integer> allLottoResult() {
        Map<String, Integer> results = setDefaultResult(new HashMap<>());

        for (Lotto lotto : this.lottos) {
            int[] comparedResult = compareWinnerAndPurchased(lotto);
            int normalHitCount = comparedResult[0];
            int bonusHitCount = comparedResult[1];

            results = makeResults(results, normalHitCount, bonusHitCount);
        }

        return results;
    }

    private double calcProfitRate(Map<String, Integer> results) {
        int totalProfit = 0;

        for (Result result : Result.values()) {
            if (results.get(result.name()) > 0) {
                totalProfit += Integer.parseInt(result.getReward()
                                .replace(SEPERATOR, NO_SPACE))
                        * results.get(result.name());
            }
        }

        return ((double) totalProfit / (this.purchasedAmount * LOTTO_PRICE_PER_GAME) * 100);
    }
}
