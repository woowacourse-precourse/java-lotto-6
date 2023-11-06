package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public LottoNumbers() {
    }

    private static List<Integer> lottoNumberList;

    public static List<Integer> setRandomNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> RandomNumbers = new ArrayList<>(lottoNumberList);
        Collections.sort(RandomNumbers);

        return RandomNumbers;
    }


}
