package lotto.domain;

import java.util.List;

public class LottoManager {
    private static AutoLottos autoLottos;
    private static Generator generator = new LottoGenerator();
    private static int lottoCount;
    private Money money;

    private LottoManager(Money money) {
        this.money = money;
        autoLottos = AutoLottos.from();
        buyAutoLottos();
    }

    public static LottoManager from(int money) {
        return new LottoManager(Money.from(money));
    }

    private void buyAutoLottos() {
        lottoCount = money.requestLottoCount();
        autoLottos.createAutoLottos(lottoCount, generator);
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos.getLottos();
    }
}
