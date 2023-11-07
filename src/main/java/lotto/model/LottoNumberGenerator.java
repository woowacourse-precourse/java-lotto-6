package lotto.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> mutableList = new ArrayList<>(lottoNumbers); // 불변 리스트를 가변 리스트로 복제
        Collections.sort(mutableList);
        return mutableList;
    }
}