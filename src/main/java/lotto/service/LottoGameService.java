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
    private int lottoCount;
    private Lotto winningLottoNumber;
    private WinningLotto winningLotto;

    public LottoGameService() {
        lottoFactory = new LottoFactory();
    }

    public String buyLotto(String inputMoney) {
        Money money = new Money(inputMoney);
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

    public void calculateResult() {
        List<LottoResult> lottoResults = userLotto.calculateResult(winningLotto);
    }
}
