package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.Lotto;

import java.util.List;

public class CreateLotto {
    public Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }
}
