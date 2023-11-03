package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }


}
