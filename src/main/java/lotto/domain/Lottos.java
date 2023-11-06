package lotto.domain;

import lotto.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private static final Integer MONEY_UNIT = 1000;

    private final List<Numbers> lottoValues = new ArrayList<>();

    public void saveLottos(PurchasePrice purchasePrice) {
        Integer lottosAmount = purchasePrice.getLottosAmount();

        IntStream.range(0, lottosAmount)
                .forEach(i -> lottoValues.add(getLotto()));
    }

    private Numbers getLotto() {
        return new Numbers(LottoRandomNumbers.getRandomNumbers());
    }

    public Integer getLottosPrice() {
        return lottoValues.size() * MONEY_UNIT;
    }

    public List<Numbers> getLottoValues() {
        return List.copyOf(lottoValues);
    }
}
