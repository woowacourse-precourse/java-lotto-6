package lotto.domain.lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoService {

    public Lotto createLotto() {

        //NOTE: 범위, 중복 여부, 갯수,  등은 자동으로 관리되는 메서드로 보임.
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

}
