package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> numberGenerator() {
        List<Integer> lottoNumbers = new ArrayList<>();
        int number;
        while (lottoNumbers.size() < Number.LOTTO_SIZE.getNumber()) {
            number = Randoms.pickNumberInRange(Number.MIN_NUMBER.getNumber(), Number.MAX_NUMBER.getNumber());
            if (!lottoNumbers.contains(number)) {
                lottoNumbers.add(number);
            }
        }
        return lottoNumbers;
    }
}
