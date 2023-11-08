package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final Price lottoPrice;

    public LottoMachine(Price lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public List<Lotto> issue(int money) {
        int quantity = lottoPrice.divide(money);
        List<Lotto> lottoTicket = new ArrayList<>();
        while (quantity != 0) {
            lottoTicket.add(new Lotto(Strategy.generateLotto()));
            quantity--;
        }
        return Collections.unmodifiableList(lottoTicket);
    }
}
