package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public record Lottos(List<Lotto> lottoItems) {

    public static Lottos purchaseLottos(Money wallet) {
        List<Lotto> lottoItems = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            Lotto newLotto = Lotto.createRandomLotto(wallet);
            lottoItems.add(newLotto);
        }
        return new Lottos(lottoItems);
    }

    public List<Lotto> getLottoItems() {
        return lottoItems;
    }

    public int size() {
        return lottoItems.size();
    }
}
