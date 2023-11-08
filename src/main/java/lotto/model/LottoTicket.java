package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Lotto> tickets;

    public LottoTicket(int numberOfTickets) {
        tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            tickets.add(lotto);
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}