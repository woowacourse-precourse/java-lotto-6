package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoMachine {
    private final LottoPrice lottoPrice;
    private LottoCreateStrategy lottoCreateStrategy;

    public LottoMachine(LottoPrice lottoPrice, LottoCreateStrategy lottoCreateStrategy ) {
        this.lottoPrice = lottoPrice;
        this.lottoCreateStrategy = lottoCreateStrategy;
    }

    public List<Lotto> issue(int money){
        int quantity = lottoPrice.calculate(money);
        List<Lotto> lottoTicket = new ArrayList<>();
        while (quantity != 0){
            lottoTicket.add(new Lotto(lottoCreateStrategy.create()));
            quantity--;
        }
        return lottoTicket;
    }
}
