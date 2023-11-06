package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    // Randoms.를 사용해서 서로다른 6개의 로또를 생성한다

    public void lottoGenerateWinningLotto(int gameAmount) {
        List<Lotto> candWinningLotto = new ArrayList<>;
        for (int i= 0; i < gameAmount; i++) {
            candWinningLotto.add(generateLottoNumber());
        }
    }

    public Lotto generateLottoNumber() {
        List<Integer> uniqueRandomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(uniqueRandomNumber);
    }

}
