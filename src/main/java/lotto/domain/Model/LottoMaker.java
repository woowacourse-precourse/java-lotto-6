package lotto.domain.Model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Utility.Constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
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
        List<Integer> numbers
                = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_START_NUMBER,
                Constant.LOTTO_END_NUMBER,
                Constant.LOTTO_PICK_NUMBER
        );
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }
}
