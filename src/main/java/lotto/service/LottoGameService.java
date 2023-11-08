package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class LottoGameService {
    private final LottoFactory lottoFactory;
    private UserLotto userLotto;
    private Money money;
    private int lottoCount;
    private Lotto winningLottoNumber;
    private WinningLotto winningLotto;

    private List<LottoResult> lottoResults;

    public LottoGameService() {
        lottoFactory = new LottoFactory();
    }

    public String buyLotto(String inputMoney) {
        money = new Money(inputMoney);
        lottoCount = money.calculateLottoCount();
        return String.valueOf(lottoCount);
    }

    public String makeLotto() {
        userLotto = lottoFactory.createLottos(lottoCount);
        return userLotto.toString();
    }

    public void makeWinningLotto(String winningLotto) {
        winningLottoNumber = lottoFactory.makeWinningLotto(winningLotto);
    }

    public void makeBonusNumber(String inputBonusNumber) {
        int bonusNumber = lottoFactory.makeBonusNumber(winningLottoNumber, inputBonusNumber);
        winningLotto = lottoFactory.makeWinningLottoWithBonusNumber(winningLottoNumber, bonusNumber);
    }

    public String calculateStatistics() {
        lottoResults = userLotto.calculateResult(winningLotto);
        return makeStatistics(lottoResults);
    }

    private String makeStatistics(List<LottoResult> lottoResults) {
        Map<LottoResult, Integer> statistics = new HashMap<>();

        lottoResults.forEach(lottoResult -> {
            statistics.put(lottoResult, statistics.getOrDefault(lottoResult, 0) + 1);
        });

        return LottoResult.makeResult(statistics);
    }

    public String calculateTotalYield() {
        return String.valueOf( money.calculateYield(lottoResults.stream()
                .mapToDouble(LottoResult::getPrizeMoney)
                .sum()));
    }
}
