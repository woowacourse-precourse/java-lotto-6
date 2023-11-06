package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionManager;

public class LottoMachine {

    private Lottos lottos;

    public void buyLottos(Money money) {
        int lottoCount = getLottoCount(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        this.lottos = new Lottos(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

    private int getLottoCount(Money money) {
        checkMoney(money);
        return money.getMoney() / LOTTO_PRICE;
    }

    private void checkMoney(Money money) {
        if (money.getMoney() % LOTTO_PRICE != 0) {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    "1,000원 단위로 입력해야 합니다.");
        }
    }

}
