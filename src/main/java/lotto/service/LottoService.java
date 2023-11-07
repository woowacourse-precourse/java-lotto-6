package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicketCount;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {

    private LottoTicketCount lottoTicket;
    private final List<Lotto> lottos;

    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public void createLottoTicket(String moneyInput) {
        this.lottoTicket = new LottoTicketCount(moneyInput);
    }

    public int getTicketCount() {
        return this.lottoTicket.getTicketCount();
    }

    public List<Lotto> generateLottoNumbers() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        int lottoCount = getTicketCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(createSingleGameLottoNumbers());
        }
        return lottoNumbers;
    }

    private Lotto createSingleGameLottoNumbers() {
        List<Integer> singleGameLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(singleGameLottoNumbers);
    }

    public void storeLottoNumbers (List<Lotto> lottoNumbers) {
        this.lottos.addAll(lottoNumbers);
    }


    public List<Lotto> purchaseLottoTickets() {
        return this.lottos;
    }
}