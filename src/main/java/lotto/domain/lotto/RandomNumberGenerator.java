package lotto.domain.lotto;

import static lotto.domain.lotto.LottoConstants.LOTTO_SIZE;
import static lotto.domain.lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private List<Integer> generatedNumbers;

    public RandomNumberGenerator() {
        this.generatedNumbers = new ArrayList<>();
    }

    @Override
    public List<Integer> generateNumbers() {
        generatedNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_SIZE.getValue());
        return Collections.unmodifiableList(generatedNumbers);
    }
}
