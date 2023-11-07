package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumber() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < 6) {
            int lottoNumber = Randoms.pickNumberInRange(1, 45);
            lottoNumbers.add(lottoNumber);
        }

        return new ArrayList<>(lottoNumbers);
    }
}
