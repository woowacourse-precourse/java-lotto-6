package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CreateLottoNumber {
    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
