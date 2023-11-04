package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.NumberGenerator;

public class LottoShop {
    private int amount;
    public LottoShop(int amount) {
        this.amount = amount;
    }

    public List<Lotto> sell() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        return IntStream.range(0, amount)
                .mapToObj(i -> numberGenerator.generate())
                .map(Lotto::new)
                .toList();
    }
}
