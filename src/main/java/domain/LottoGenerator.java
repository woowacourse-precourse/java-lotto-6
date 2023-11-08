package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoNumbers(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(singleLotto));
        }

        return lottos;
    }
}