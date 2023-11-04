package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private static List<Lotto> lottos;
    private static Generator generator = new LottoGenerator();
    private static int lottoCount;
    private Money money;

    private LottoManager(Money money) {
        this.money = money;
        buyLottos();
    }

    public static LottoManager from(int money) {
        return new LottoManager(Money.from(money));
    }

    public void buyLottos() {
        lottos = new ArrayList<>();
        lottoCount = money.requestLottoCount();
        while (checkMoneyRemain(lottoCount)) {
            lottos.add(getNewLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private Lotto getNewLotto() {
        lottoCount -= 1;
        return Lotto.createAutoLottoNumbers(generator);
    }

    private boolean checkMoneyRemain(int lottoCount) {
        return lottoCount != 0;
    }

}
