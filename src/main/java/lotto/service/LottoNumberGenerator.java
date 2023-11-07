package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberGenerator {

    public enum LottoConfiguration {
        MIN(1),
        MAX(45),
        COUNT(6);

        private final int value;

        LottoConfiguration(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public List<Integer> generateLottoNumber() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < LottoConfiguration.COUNT.getValue()) {
            int lottoNumber = Randoms.pickNumberInRange(
                LottoConfiguration.MIN.getValue(),
                LottoConfiguration.MAX.getValue()
            );
            lottoNumbers.add(lottoNumber);
        }

        return new ArrayList<>(lottoNumbers);
    }
}
