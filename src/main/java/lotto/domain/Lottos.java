package lotto.domain;

import lotto.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void saveLottos(LottoPurchasePrice purchasePrice) {
        Integer lottosAmount = purchasePrice.getLottosAmount();

        IntStream.range(0, lottosAmount)
                .forEach(i -> lottos.add(getLotto()));
    }

    private Lotto getLotto() {
        return new Lotto(LottoRandomNumbers.getRandomNumbers());
    }
}
