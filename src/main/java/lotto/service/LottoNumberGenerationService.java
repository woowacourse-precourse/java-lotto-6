package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

import java.util.List;

public class LottoNumberGenerationService {

    private final LottoMachine lottoMachine;

    public LottoNumberGenerationService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> generateLottoNumbers(int lottoTicketsCount) {
        return lottoMachine.issueTickets(lottoTicketsCount);
    }
}