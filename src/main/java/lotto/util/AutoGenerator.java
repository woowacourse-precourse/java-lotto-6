package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoGenerator extends LottoNumbersGenerator {
    @Override
    protected void generateLottoNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
