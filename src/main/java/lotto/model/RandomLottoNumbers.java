package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.util.ConstantNumbers.LOTTO_NUMBER_QUANTITY;
import static lotto.util.ConstantNumbers.MAXIMUM_RANDOM_NUMBER;
import static lotto.util.ConstantNumbers.MINIMUM_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class RandomLottoNumbers {
    private static RandomLottoNumbers randomLottoNumbers;

    private final List<Lotto> randomLottoTickets;

    private RandomLottoNumbers(Integer count) {
        this.randomLottoTickets = createRandomLottoNumbers(count);
    }

    public static RandomLottoNumbers of (Integer count) {
        if (randomLottoNumbers == null) {
            randomLottoNumbers = new RandomLottoNumbers(count);
        }
        return randomLottoNumbers;
    }

    private List<Lotto> createRandomLottoNumbers (Integer count) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i=0; i < count; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(MINIMUM_RANDOM_NUMBER.getConstant(), MAXIMUM_RANDOM_NUMBER.getConstant(), LOTTO_NUMBER_QUANTITY.getConstant()));

            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : randomLottoTickets) {
            stringBuilder.append(lotto.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
