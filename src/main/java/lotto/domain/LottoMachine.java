package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.NumberConstants.*;

public class LottoMachine {

    private final List<Lotto> lottoPapers = new ArrayList<>();

    public LottoMachine(int amount) {
        createLotto(amount);
    }

    public void createLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> randomSixNumbers = new ArrayList<>(pickLottoNumber());
            Collections.sort(randomSixNumbers);
            lottoPapers.add(new Lotto(randomSixNumbers));
        }
    }

    private static List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_MIN,
                NUMBER_RANGE_MAX,
                WINNING_NUMBER);
    }

    public List<Lotto> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }
}
