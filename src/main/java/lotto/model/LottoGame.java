package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoValue;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.UserLottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    // 가격 만큼 로또 장 수 발행
    public UserLottos generateAllLottos(Price price) {
        int totalLottoCnt = price.getPrice() / LottoValue.PRICE_PER_PIECE.getValue(); // 사용자가 구매한 로또 장 수

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCnt; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return new UserLottos(lottos);
    }

    // 로또 한 장 발행
    private Lotto generateLotto() {
        int startRange = LottoValue.MIN_VALUE.getValue();
        int endRange = LottoValue.MAX_VALUE.getValue();
        int cnt = LottoValue.WINNING_NUMBER_CNT.getValue();

        return new Lotto(pickRandNums(startRange, endRange, cnt));
    }

    private List<Integer> pickRandNums(int start, int end, int cnt) {
        return Randoms.pickUniqueNumbersInRange(start, end, cnt);

    }
}
