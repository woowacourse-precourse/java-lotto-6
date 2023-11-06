package lotto.service;

import lotto.domain.Lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoService {

    public Lotto generateLotto() {
        List<Integer> list = generateLottoCombination();
        return new Lotto(list);
    }

    public List<Integer> generateLottoCombination() {
        List<Integer> list = pickUniqueNumbersInRange(1, 45, 6);
        list.sort(null);
        return list;
    }

}
