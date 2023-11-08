package lotto.domain.lotto;

import lotto.constants.lotto.LottoRule;
import lotto.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerLottoNumbers {

    private final List<Numbers> lottoValues = new ArrayList<>();

    public void saveLottos(PurchasePrice purchasePrice) {
        Integer lottosAmount = purchasePrice.getLottosAmount();

        IntStream.range(LottoRule.INIT_VALUE, lottosAmount)
                .forEach(i -> lottoValues.add(getLottoNumbers()));
    }

    private Numbers getLottoNumbers() {
        return new Numbers(LottoRandomNumbers.getRandomNumbers());
    }

    public Integer getLottosPrice() {
        return lottoValues.size() * LottoRule.MONEY_UNIT;
    }

    public List<Numbers> getLottoValues() {
        return List.copyOf(lottoValues);
    }
}
