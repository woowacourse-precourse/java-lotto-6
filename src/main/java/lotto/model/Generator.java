package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
    public static List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().distinct().sorted()
                .collect(Collectors.toList());
        return numbers;
    }


}
