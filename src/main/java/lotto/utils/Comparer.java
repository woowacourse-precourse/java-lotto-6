package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class Comparer {

    static int compareLottos(Lotto lotto1, Lotto lotto2) {
        List<Integer> sameNumbers = new ArrayList<>(lotto1.getNumbers());
        sameNumbers.removeAll(lotto2.getNumbers());
        return sameNumbers.size();
    }

}
