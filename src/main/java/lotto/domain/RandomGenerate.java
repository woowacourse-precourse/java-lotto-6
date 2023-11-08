package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerate {
    public List<List<Integer>> createNumbers(int quantity) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> orderNumbers = new ArrayList<>(numbers);
            Collections.sort(orderNumbers);
            allLottoNumbers.add(orderNumbers);
        }
        return allLottoNumbers;
    }
}
