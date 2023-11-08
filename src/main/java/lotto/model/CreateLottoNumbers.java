package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumbers {
    public List<Integer> createRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumber = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
