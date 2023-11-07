package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

import static lotto.constant.Constant.*;

public class LottoService {

    public void createLotto(int lottoCount, List<Lotto> lotto) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_SIZE);
            lotto.add(new Lotto(numbers));
        }
    }
}
