package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class NumberGenerator implements Numbergeneratable {

    public List<Integer> generateNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
