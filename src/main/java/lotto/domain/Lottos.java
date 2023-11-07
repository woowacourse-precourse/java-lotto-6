package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoItems;
    private int count;

    private Lottos(List<Lotto> lottos, int count) {
        this.lottoItems = lottos;
        this.count = count;
    }

    public static Lottos purchaseLottos(Money wallet) {
        List<Lotto> lottoItems = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            Lotto newLotto = Lotto.createRandomLotto(wallet);
            lottoItems.add(newLotto);
        }
        return new Lottos(lottoItems, lottoItems.size());
    }


    public String getLottosNumber() {
        return lottoItems.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottoItems() {
        return lottoItems;
    }

    public int getCount() {
        return count;
    }
}
