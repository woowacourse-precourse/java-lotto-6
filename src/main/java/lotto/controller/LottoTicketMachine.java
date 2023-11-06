package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {
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
