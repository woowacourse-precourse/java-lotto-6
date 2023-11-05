package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final int NUMBER_OF_GENERATION = 6;
    public List<Integer> numberGenerator() {
        List<Integer> lottoNumbers = new ArrayList<>();
        int number;
        while(lottoNumbers.size() < NUMBER_OF_GENERATION){
            number = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(number)) {
                lottoNumbers.add(number);
            }
        }
        return lottoNumbers;
    }
}
