package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoMachine {

    public Lotto makeLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.addAll(numbers);
        Collections.sort(lottoNumbers);

        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }
}
