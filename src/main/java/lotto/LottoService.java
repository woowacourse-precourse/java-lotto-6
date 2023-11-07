package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    static final int COUNT_NUMBER = 6;

    List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_NUMBER);

        return randomNumbers;
    }

    Lotto getLotto() {
        List<Integer> randomNumbers = getRandomNumbers();

        Lotto lotto = new Lotto(randomNumbers);

        return lotto;
    }

    List<Lotto> getLottoBundle(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0 ; i < purchaseAmount; i++) {
            Lotto lotto = getLotto();
            lottos.add(lotto);
        }

        return lottos;
    }



}
