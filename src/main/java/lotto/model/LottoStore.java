package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.lottogenerator.LottoGenerator;
import lotto.util.LottoGameException;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_MAX = 100_000;

    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator){
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchase(int money) {
        checkMoneyRange(money);
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = money / LOTTO_PRICE;
        while (lottos.size() < lottoNum) {
            Lotto generatedLotto = lottoGenerator.generate();
            lottos.add(generatedLotto);
        }

        return new Lottos(lottos);
    }

    private void checkMoneyRange(int money) {
        if(money > PURCHASE_MAX){
            throw LottoGameException.OVER_PURCHASE_LIMIT.makeException();
        }
    }
}
