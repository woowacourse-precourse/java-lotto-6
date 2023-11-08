package lotto;

import static lotto.LottoGenerator.makeRandomNumbersInLotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private List<Lotto> lottos = new ArrayList<>();
    private final Purchase purchase;
    public PurchasedLottos(Purchase purchase) {
        this.purchase = purchase;
        for (int i = 0; i < purchase.getTicketCount(); i++) {
            Lotto lotto = new Lotto(makeRandomNumbersInLotto());
            lottos.add(lotto);
        }
    }
    public String LottosToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
