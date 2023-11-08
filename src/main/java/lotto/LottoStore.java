package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStore {
    private List<Lotto> lottos;
    private List<Integer>winCount;

    LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winCount = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
    }

    public static LottoStore createLottoStore(int numberOfLotto) {
        private List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = numberOfLotto ; i > 0 ; i++) {
            lottos.add(Lotto.createLotto());
        }
        return new LottoStore(lottos);
    }
}
