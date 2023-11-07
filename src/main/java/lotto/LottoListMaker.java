package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoListMaker {

    public static List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = LottoMaker.makeLotto();
            lottoList.add(lotto);
        }
        return lottoList;

    }

}
