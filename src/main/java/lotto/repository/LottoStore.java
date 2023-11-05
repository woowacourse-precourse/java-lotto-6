package lotto.repository;

import static lotto.constant.Game.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.RegexValidator;
import lotto.domain.Lotto;
import lotto.util.LottoNumberGenerator;

public class LottoStore {
    private final List<Lotto> lottos;
    private final int money;

    public LottoStore(String moneyInput) {
        RegexValidator.PRICE.validate(moneyInput);
        this.money = Integer.parseInt(moneyInput);
        this.lottos = new ArrayList<>();
    }

    public int buy() {
        int buyCount = money / LOTTO_PRICE.getNum();

        for (int count = 0; count < buyCount; count++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }

        return buyCount;
    }

    public int getMoney() {
        return money;
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


}
