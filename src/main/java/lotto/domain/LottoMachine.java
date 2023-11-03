package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public Lotto issueLotto() {
        return new Lotto(createLottoNumbers());
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers); // 오름차순 정렬
        return numbers;
    }
}
