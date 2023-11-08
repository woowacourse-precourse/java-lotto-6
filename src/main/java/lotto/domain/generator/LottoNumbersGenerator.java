package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGenerator {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 1;
    private static final Integer PICK_NUMBER = 1;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER);
    }
}
