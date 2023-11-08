package lotto.module.application;


import static lotto.global.constant.Game.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.module.domain.Lotto;
import lotto.module.domain.LottoNumbersGenerator;
import lotto.module.domain.Lottos;

public class LottoService {

    private Lottos lottos;

    public void inputAmount(Long amount) {
        int quantity = (int) (amount / LOTTO_PRICE);
    }

    public void generateLottos(int quantity) {
        lottos = new Lottos(generateLotto(quantity));
    }

    public List<Lotto> generateLotto(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
            result.add(lotto);
        }
        return result;
    }

}