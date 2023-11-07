package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos of(final int numberOfLottos, final LottoGenerator lottoGenerator) {
        final List<Lotto> purchasedLottos = new ArrayList<>(numberOfLottos);

        for (int i = 0; i < numberOfLottos; i++) {
            final Lotto newLotto = lottoGenerator.generate();
            purchasedLottos.add(newLotto);
        }

        return new PurchasedLottos(purchasedLottos);
    }

    public List<WinningInfo> getWinnningInfos(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::compare)
                .toList();
    }


    public List<String> getPurchaseLottos() {
        return lottos.stream()
                .map(Lotto::getPurchaseLotto)
                .toList();
    }
}
