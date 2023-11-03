package lotto.domain;

import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomGenerator;

public class LottoGenerator {

    private List<Integer> lottoNumbers;

    public List<Integer> generateLottoNumbers() {
        lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() != LOTTO_SIZE.getInfo()) {
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
        if (MINIMUM_NUMBER.getInfo() > randomNumber || MAXIMUM_NUMBER.getInfo() < randomNumber) {
            return false;
        }
        return true;
    }

}
