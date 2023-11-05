package lotto.control;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public List<Lotto> createLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Lotto.getLottoNumbers()));
        }
        return lottos;
    }
}
