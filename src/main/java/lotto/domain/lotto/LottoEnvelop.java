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

        StringBuilder information = getInformation(sizeLottoEnvelop);

        return information;
    }

    private StringBuilder getInformation(int sizeLottoEnvelop) {
        Lotto lotto;
        StringBuilder lottoInformation;
        StringBuilder information = new StringBuilder();

        for (int i = 0; i < sizeLottoEnvelop; i++) {
            lotto = getLotto(i);
            lottoInformation = lotto.giveInformation();
            information.append(lottoInformation + "\n");
        }
        return information;
    }

    private Lotto getLotto(int i) {
        return lottoEnvelops.get(i);
    }

    public Lotto takeLotto(Integer index) {
        return this.lottoEnvelops.get(index);
    }
}
