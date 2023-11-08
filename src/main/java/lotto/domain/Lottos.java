package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static List<Lotto> createLotto(Integer lottoCount, Lotto lotto) {
        List<Lotto> lottoLst = new ArrayList<>();
        for (int i =0; i<lottoCount; i++) {
            lottoLst.add(lotto);
        }
        return lottoLst;
    }

}
