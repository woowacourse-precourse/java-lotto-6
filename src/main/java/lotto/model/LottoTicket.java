package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    private LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = new ArrayList<>(lottoTicket);
    }

    protected static LottoTicket createLottoTicket(int count) {

    }

    public WinStatistics getRank(Lotto winLotto, Bonus bonus) {

    }

    public String printResult() {

    }
}
