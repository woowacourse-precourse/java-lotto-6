package lotto.domain;

import lotto.constants.LottoEnum;
import lotto.utils.CommonHelper;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    int numberOfTickets;

    public LottoManager(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public List<Lotto> createLotto(int ticketCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            lottos.add(new Lotto(CommonHelper.listSort(CommonHelper.numGenerator())));
        }
        return lottos;
    }
}
