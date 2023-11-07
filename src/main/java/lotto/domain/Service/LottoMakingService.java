package lotto.domain.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class LottoMakingService {

    public LottoContainer issue(int cash) {
        int papers = cash / Constant.LOTTO_PRICE;

        LottoContainer lottoContainer = new LottoContainer();

        for (int i = 0; i < papers; i++) {
            lottoContainer.add(issueLottoPaper());
        }

        return lottoContainer;
    }

    public Lotto issueLottoPaper() {
        List<Integer> numbers
                = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        Constant.LOTTO_START_NUMBER,
                        Constant.LOTTO_END_NUMBER,
                        Constant.LOTTO_PICK_NUMBER
                )
        );
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }
}
