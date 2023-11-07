package lotto;

import java.util.ArrayList;

public class LottoListMaker {

    public static ArrayList<Lotto> makeLottoList(int lottoCount) {
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = LottoMaker.makeLotto();
            lottoList.add(lotto);
        }
        return lottoList;

    }

}
