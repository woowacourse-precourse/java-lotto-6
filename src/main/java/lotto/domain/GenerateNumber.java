package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumber {
    public List<Integer> randomLottoCreate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
