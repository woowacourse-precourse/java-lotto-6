package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_SIZE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private final List<Integer> generatedNumbers;

    public RandomNumberGenerator() {
        this.generatedNumbers = new ArrayList<>();
    }

    @Override
    public List<Integer> generateNumbers() {
        while (generatedNumbers.size() < LOTTO_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return Collections.unmodifiableList(generatedNumbers);
    }
}
