package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;

/*
 *   로또 게임의 비즈니스 기능을 담당
 * */

public class LottoService {

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
            lottos.add(lotto);
        }
        return Lottos.from(lottos);

    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }
}
