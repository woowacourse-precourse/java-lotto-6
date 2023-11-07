package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoItems;

    private Lottos(List<Lotto> lottos) {
        this.lottoItems = lottos;
    }

    public static Lottos purchaseLottos(Money wallet) {
        List<Lotto> lottoItems = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            Lotto newLotto = Lotto.createRandomLotto(wallet);
            lottoItems.add(newLotto);
        }
        return new Lottos(lottoItems);
    }


    public String getLottosNumber() {
        return lottoItems.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottoItems() {
        return lottoItems;
    }

    public int size() {
        return lottoItems.size();
    }
}
