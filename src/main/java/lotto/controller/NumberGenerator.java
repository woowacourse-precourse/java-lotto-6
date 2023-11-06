package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }

    public Lotto createLotto() {
        List<Integer> lottoNumber;
        Lotto lotto;

        while (true) {
            try {
                lottoNumber = createLottoNumbers();
                lotto = new Lotto(lottoNumber);
            } catch (IllegalArgumentException exception) {
                continue;
            }

            break;
        }

        return lotto;
    }
}
