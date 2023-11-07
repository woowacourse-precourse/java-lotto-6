package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class LottoGameService {
    private LottoFactory lottoFactory;
    private UserLotto userLotto;
    private Money money;
    private int lottoCount;
    private Lotto winningLottoNumber;
    private WinningLotto winningLotto;

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

    public String calculateResult() {
        List<LottoResult> lottoResults = userLotto.calculateResult(winningLotto);
        return String.valueOf(calculateTotalYield(lottoResults));
    }

    private double calculateTotalYield(List<LottoResult> lottoResults) {
        return money.calculateYield(lottoResults.stream()
                .mapToDouble(LottoResult::getPrizeMoney)
                .sum());
    }
}
