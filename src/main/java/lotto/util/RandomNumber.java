package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber {

    public static List<Integer> createRandomLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.stream().forEach(number -> System.out.print(number + " "));
        return numbers;
    }
}
