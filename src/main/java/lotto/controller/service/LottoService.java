package lotto.controller.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.utils.NumberGenerator;

public class LottoService {

    private NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottoNumbers(LottoMoney money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = 0;
        int quantity = money.calculateCountLottoPrice();
        while (lottoCount < quantity) {
            Lotto lotto = new Lotto(numberGenerator.createSixDigitNumber());
            lottos.add(lotto);
            lottoCount++;
        }
        return lottos;
    }
}
