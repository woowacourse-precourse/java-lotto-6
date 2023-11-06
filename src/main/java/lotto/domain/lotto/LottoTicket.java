package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    List<Lotto> lottoTicket = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottoTicket.add(lotto);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
