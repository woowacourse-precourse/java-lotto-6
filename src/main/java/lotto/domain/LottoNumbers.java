package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 46;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoNumbers() {
    }

    private static List<Integer> lottoNumberList;

    public static List<Integer> setLottoNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
        List<Integer> RandomNumbers = new ArrayList<>(lottoNumberList);
        Collections.sort(RandomNumbers);

        return RandomNumbers;
    }


}