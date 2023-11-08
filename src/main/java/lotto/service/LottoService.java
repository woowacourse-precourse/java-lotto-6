package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
