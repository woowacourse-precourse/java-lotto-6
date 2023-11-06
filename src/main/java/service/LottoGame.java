package service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGame {
    public List<Lotto> generateLottoTickets(int lottoTicketCount, List<Integer> lottoNumbers) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 1; i <= lottoTicketCount; i++) {
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        return lottoTickets;
    }
}
