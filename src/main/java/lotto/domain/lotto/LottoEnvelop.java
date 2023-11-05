package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoEnvelop {
    private List<Lotto> lottoEnvelops;

    public LottoEnvelop() {
        lottoEnvelops = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoEnvelops.add(lotto);
    }

    public Integer size() {
        return lottoEnvelops.size();
    }

    public StringBuilder giveInformation() {
        int sizeLottoEnvelop = lottoEnvelops.size();
        StringBuilder information = new StringBuilder();
        Lotto lotto = null;
        StringBuilder lottoInformation = null;

        for (int i = 0; i < sizeLottoEnvelop; i++) {
            lotto = lottoEnvelops.get(i);
            lottoInformation = lotto.giveInformation();
            information.append(lottoInformation + "\n");
        }

        return information;
    }
}
