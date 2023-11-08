package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;
import static lotto.Constraints.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {
    List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(),
                MAX_NUMBER.getValue(),
                SIZE.getValue()
        );
        List<Integer> sortedRandomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedRandomNumbers);
        return sortedRandomNumbers;
    }

    public List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}