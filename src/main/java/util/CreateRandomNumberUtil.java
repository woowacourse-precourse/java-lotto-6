package util;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumberUtil {
    public static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }
}
