package lotto.domain;

import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {
    public final List<Integer> numbers;

    public LottoNumbers() {
        this.numbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
