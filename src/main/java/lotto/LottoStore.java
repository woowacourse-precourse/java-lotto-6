package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMoney;

public class LottoStore {

    private NumberGenerator numberGenerator;

    public LottoStore(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> receiveLottoNumbers(LottoMoney money) {
        int quantity = money.calculateCountLottoPrice();
        return createLottoNumbers(quantity);
    }

    public List<Lotto> createLottoNumbers(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = 0;
        while (lottoCount < quantity) {
            Lotto lotto = new Lotto(numberGenerator.createSixDigitNumber());
            lottos.add(lotto);
            lottoCount++;
        }
        return lottos;
    }
}
