package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoService {




    public List<Integer> generateLottoCombination() {
        List<Integer> list = pickUniqueNumbersInRange(1, 45, 6);
        list.sort(null);
        return list;
    }

}
