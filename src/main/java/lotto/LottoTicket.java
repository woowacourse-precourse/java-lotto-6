package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }


    public List<String> makeLottoToString() {
        List<String> lottoInventory = new ArrayList<>();
        for (Lotto lotto : lottoTicket) {
            lotto.sort();
            lottoInventory.add(lotto.toString());
        }
        return lottoInventory;
    }


}
