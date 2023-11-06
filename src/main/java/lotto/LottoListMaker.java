package lotto;

import java.util.ArrayList;

import static lotto.constants.ConstantValues.*;

public class LottoListMaker {

    public static int getLottoListSize(int money) {
        return money / LOTTO_COST.getValue();
    }

    public static ArrayList<Lotto> makeLottoList(int money) {
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < getLottoListSize(money); i++) {
            Lotto lotto = LottoMaker.makeLotto();
            lottoList.add(lotto);
        }
        return lottoList;

    }

}
