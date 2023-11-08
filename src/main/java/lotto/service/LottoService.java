package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int minNum = 1;
    private static final int maxNum = 45;
    private static final int pickNum = 6;

    public static List<Lotto> getAllLottos(Long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i<count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minNum, maxNum, pickNum);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
