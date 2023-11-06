package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {

    private LottoTicket lottoTicket;
    private List<Lotto> lottos;
    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public void createLottoTicket(String moneyInput) {
        this.lottoTicket = new LottoTicket(moneyInput);
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