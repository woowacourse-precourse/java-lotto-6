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

    public List<Lotto> generateLottoTickets() {
        List<Lotto> generatedLottos = new ArrayList<>();
        int lottoCount = getTicketCount();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(lottoNumbers);
            generatedLottos.add(newLotto);
        }
        this.lottos.addAll(generatedLottos);
        return generatedLottos;
    }

    public List<Lotto> purchaseLottoTickets() {
        return this.lottos;
    }
}