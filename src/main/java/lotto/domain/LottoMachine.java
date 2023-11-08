package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.NumberGenerator;

public class LottoMachine implements NumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_OF_RANDOM_NUMBERS = 6;

    @Override
    public List<Integer> generator() {
        List<Integer> lottoNumbers = new ArrayList<Integer>(
                Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                        NUMBER_OF_RANDOM_NUMBERS));
        ascendingSortLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private void ascendingSortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
