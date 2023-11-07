package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Constant;
import lotto.Util.LottoGenerator;

public class TotalLotto {
    private final List<Lotto> totalLotto;

    private final int lottoAmount;

    public TotalLotto(Money money) {
        totalLotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoAmount = money.getValue() / Constant.LOTTO_PRICE;
        for (int i = 0; i < lottoAmount; i++) {
            totalLotto.add(lottoGenerator.generateLotto());
        }
    }

    public List<Lotto> getTotalLotto() {
        return totalLotto;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
