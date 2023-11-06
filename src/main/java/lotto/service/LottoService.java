package lotto.service;

import lotto.domain.Lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> generateLottoList(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(generateLotto());
        }

        return result;
    }

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
