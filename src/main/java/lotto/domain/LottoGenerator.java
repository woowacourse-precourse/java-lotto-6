package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomGenerator;

public class LottoGenerator {

    private static final int LOTTO_SIZE = 6;

    private List<Integer> lottoNumbers;

    public List<Integer> generateLottoNumbers() {
        lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() != LOTTO_SIZE) {
            int randomNumber = RandomGenerator.generateNumber();
            if (!isDuplicateNumber(randomNumber) && isValidNumberRange(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return lottoNumbers;
    }

    private boolean isDuplicateNumber(int randomNumber) {
        if (lottoNumbers.contains(randomNumber)) {
            return true;
        }
        return false;
    }

    private boolean isValidNumberRange(int randomNumber) {
        if (1 > randomNumber || 45 < randomNumber) {
            return false;
        }
        return true;
    }

}
