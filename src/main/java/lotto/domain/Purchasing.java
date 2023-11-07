package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Purchasing {
    List<Lotto> purchasedLottos;
    LottoGenerator lottoGenerator = new LottoGenerator();
    int ticketQuantity = 0;

    public void purchaseLottos(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
        purchasedLottos = new ArrayList<>();
        for (int i = 0; i < ticketQuantity; i++) {
            Lotto generatedLotto = lottoGenerator.generateLotto();
            purchasedLottos.add(generatedLotto);
        }
    }

    public int getPurchasedLottoQuantity() {
        return ticketQuantity;
    }

    public List<Lotto> getPurchasedLottos() {return purchasedLottos;}
}
