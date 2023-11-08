package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import static lotto.util.Util.*;

public class Service {
    public void createLotto(Buyer buyer){
        int count = buyer.getCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = createRandomNumbers();
            buyer.buyLotto(lotto);
        }
    }

}