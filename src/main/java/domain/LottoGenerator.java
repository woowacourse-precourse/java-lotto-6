package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<List<Integer>> generateLottoNumbers(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(singleLotto);
            lottos.add(singleLotto);
        }

        return lottos;
    }
}