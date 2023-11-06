package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Ranking.*;


import lotto.domain.Lotto;
import lotto.domain.Ranking;
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

    public Ranking calculateRanking(Lotto target, Lotto answer, int bonusNumber) {
        int count = target.countMatchingNumber(answer);

        if (count == 3) {
            return FIFTH;
        }

        if (count == 4) {
            return FORTH;
        }

        if (count == 5 && !target.isNumberIn(bonusNumber)) {
            return THIRD;
        }

        if (count == 5 && target.isNumberIn(bonusNumber)) {
            return SECOND;
        }

        if (count == 6) {
            return FIRST;
        }

        return SIXTH;
    }

}
