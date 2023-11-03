package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class GetLottoTicket {
    public static Lottos setLottoTickets(int lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(setLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto setLotto() {
        Lotto lotto = new Lotto();
        return lotto;
    }
}
