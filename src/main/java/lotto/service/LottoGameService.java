package lotto.service;

import lotto.model.Money;
import lotto.model.UserLotto;

public class LottoGameService {
    private LottoFactory lottoFactory;
    private UserLotto userLotto;
    private Money money;
    private int lottoCount;

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
}
