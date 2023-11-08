package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.port.LottoNumbersProvider;

public class LottoMachine {

    private final LottoNumbersProvider lottoNumbersProvider;

    public LottoMachine(LottoNumbersProvider lottoNumbersProvider) {
        this.lottoNumbersProvider = lottoNumbersProvider;
    }

    public List<Lotto> issueTickets(int lottoTicketsCount) {
        List<Lotto> issuedTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketsCount; i++) {
            Lotto ticket = lottoNumbersProvider.provideLottoNumbers();
            issuedTickets.add(ticket);
        }
        return issuedTickets;
    }
}
