package lotto.domain.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int PICK_NUMBER = 6;

    public LottoMaker() {
    }

    public LottoContainer issue(int cash) {
        int papers = cash / 1000;

        LottoContainer lottoContainer = new LottoContainer();

        for (int i = 0; i < papers; i++) {
            lottoContainer.add(issueLottoPaper());
        }

        return lottoContainer;
    }

    public Lotto issueLottoPaper() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_NUMBER);
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }
}
