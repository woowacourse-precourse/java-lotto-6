package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {


    public List<Lotto> lottoGenerateWinningLotto(int gameAmount) {
        List<Lotto> candWinningLotto = new ArrayList<>();
        for (int i= 0; i < gameAmount; i++) {
            candWinningLotto.add(generateLottoNumber());
        }
        return candWinningLotto;
    }

    public Lotto generateLottoNumber() {
        List<Integer> uniqueRandomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(uniqueRandomNumber);
    }

}
