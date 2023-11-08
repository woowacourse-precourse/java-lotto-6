package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    //구매한 로또를 생성하고 저장하는 기능을 추가
    public static List<Lotto> buyLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / Lotto.PRICE_PER_TICKET;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = LottoGenerator.generateLotto();
            lottos.add(lotto);
        }

        return lottos;
    }
}
