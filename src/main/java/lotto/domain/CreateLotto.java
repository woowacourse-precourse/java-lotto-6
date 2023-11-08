package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateLotto {

    private final static int LOTTO_LENGTH = 6;
    private final static int LOTTO_NUM_MIN_RANGE = 1;
    private final static int LOTTO_NUM_MAX_RANGE = 45;

    public List<List<Integer>> createLotto(int lottoCounts) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN_RANGE, LOTTO_NUM_MAX_RANGE,
                    LOTTO_LENGTH);
            List<Integer> list = lottoNumbers.stream().sorted().toList();
            lottoList.add(list);
            System.out.println(list);
        }

        return lottoList;
    }
}
