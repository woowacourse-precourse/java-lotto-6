package lotto.service;

import lotto.model.Money;
import lotto.model.UserLotto;

public class LottoGameService {
    private LottoFactory lottoFactory;
    private UserLotto userLotto;
    private Money money;

    public LottoGameService() {
        lottoFactory = new LottoFactory();
    }

    public void buyLotto(String inputMoney) {
        money = new Money(inputMoney);
    }
    public String makeLotto() {
        userLotto = lottoFactory.createLottos(money.calculateLottoCount());
        return userLotto.toString();
    }
}
