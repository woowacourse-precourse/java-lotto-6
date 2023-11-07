package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository();
    private List<Lotto> lottoTicket = new ArrayList<>();

    public static LottoRepository getInstance() {
        return instance;
    }

    private LottoRepository() {
    }

    public void addLotto(Lotto lotto) {
        lottoTicket.add(lotto);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }


}
