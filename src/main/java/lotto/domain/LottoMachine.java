package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int PURCHASE_LOTTO_MONEY = 1000;

    public LottoTicket buy(Money money, LottoGenerator lottoGenerator) {
        int count = getLottoCount(money);
        List<Lotto> lottos = generate(count, lottoGenerator);
        return new LottoTicket(lottos);
    }

    private int getLottoCount(Money money) {
        int requestMoney = money.getMoney();
        return requestMoney / PURCHASE_LOTTO_MONEY;
    }

    private List<Lotto> generate(int count, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }
}
