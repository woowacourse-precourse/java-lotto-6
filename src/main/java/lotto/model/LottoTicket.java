package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public static LottoTicket generate(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(Lotto.generate());
        }
        return new LottoTicket(lottoList);
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(lottoList);
    }
}
