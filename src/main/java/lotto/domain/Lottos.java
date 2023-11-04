package lotto.domain;

import lotto.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Numbers> lottoValues = new ArrayList<>();

    public void saveLottos(LottoPurchasePrice purchasePrice) {
        Integer lottosAmount = purchasePrice.getLottosAmount();

        IntStream.range(0, lottosAmount)
                .forEach(i -> lottoValues.add(getLotto()));
    }

    private Numbers getLotto() {
        return new Numbers(LottoRandomNumbers.getRandomNumbers());
    }
}
