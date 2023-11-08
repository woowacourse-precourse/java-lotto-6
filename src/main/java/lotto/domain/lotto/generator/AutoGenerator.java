package lotto.domain.lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AutoGenerator extends LottoNumbersGenerator {
    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
