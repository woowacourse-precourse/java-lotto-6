package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberGenerator {

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<List<Integer>> generateLottoNumbers(int purchaseAmount) {
        return Stream.generate(() -> generateLottoNumber()).limit(purchaseAmount)
                .collect(Collectors.toList());
    }
}
