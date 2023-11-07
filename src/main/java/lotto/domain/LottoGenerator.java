package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PICK_NUMBER = 6;

    public static List<Lotto> generateLotto(int lottoQuantity) {
        List<Lotto> pickLotto = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            pickLotto.add(lotto);
        }

        return pickLotto;
    }
}
