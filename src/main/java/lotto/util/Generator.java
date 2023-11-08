package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Model.Lotto;

public class Generator {
    public static Lotto generateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }
}
