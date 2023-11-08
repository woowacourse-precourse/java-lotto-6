package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.message.ExceptionMessage;

public record Lottos(List<Lotto> lottoItems) {

    public Lottos {
        validateNull(lottoItems);
    }

    private void validateNull(List<Lotto> lottoItems) {
        if (lottoItems == null) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL);
        }
    }

    public static Lottos purchaseLottos(Money wallet) {
        List<Lotto> lottoItems = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            Lotto newLotto = Lotto.createRandomLotto(wallet);
            lottoItems.add(newLotto);
        }
        return new Lottos(lottoItems);
    }

    public int size() {
        return lottoItems.size();
    }
}
