package lotto.model;

import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static LottoTicket issue(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = createSingleLotto();
            lottos.add(lotto);
        }
        return new LottoTicket(lottos);
    }

    private static Lotto createSingleLotto() {
        return new Lotto(LottoNumberGenerator.pickLottoNumbers());
    }
}
