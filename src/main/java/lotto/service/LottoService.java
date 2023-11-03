package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;

public class LottoService {

    public PurchasePrice createPurchasePrice(String input) {
        try {
            return PurchasePrice.from(input);
        } catch (IllegalArgumentException e) {
            return createPurchasePrice(input);
        }
    }

    public Player createPlayer(PurchasePrice purchasePrice) {
        //로또 생성
        //로또를 lottos로 변환
        Lottos lottos = createLottos(purchasePrice);
        return Player.of(purchasePrice, lottos);
        //lottos를 player에게 넣어주기
    }

    private Lottos createLottos(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();
        //굳이 보여줘야할까 밑에 내용
        int purchaseCount = purchasePrice.calculatePurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = createLotto();
            lotto.show();
            lottos.add(lotto);
        }
        return Lottos.from(lottos);

    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
