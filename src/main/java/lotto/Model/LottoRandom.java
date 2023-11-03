package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoRandom {
    public List getBuyLotto(int k) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        };
        return numbers;
    }
}
