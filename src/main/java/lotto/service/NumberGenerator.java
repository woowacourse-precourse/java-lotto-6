package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public enum LottoConfiguration {
        MIN_NUMBER(1),
        MAX_NUMBER(45),
        NUMBERS(6);

        private final int value;

        LottoConfiguration(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConfiguration.MIN_NUMBER.getValue(),
                LottoConfiguration.MAX_NUMBER.getValue(),
                LottoConfiguration.NUMBERS.getValue()
        );

        return lottoNumbers;
    }
}
