package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Range;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Integer> getRandomNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int number : createNumbers()) {
            result.add(number);
        }
        result.sort(null);
        return result;
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Range.START.getValue(), Range.END.getValue(), Range.SIZE.getValue()
        );
    }

}
