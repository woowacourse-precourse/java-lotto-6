package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> showLottoNumbers() {
        List<List<Integer>> numbers = new ArrayList<>();
        for (Lotto lotto : lottoTicket) {
            numbers.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(numbers);
    }


}
