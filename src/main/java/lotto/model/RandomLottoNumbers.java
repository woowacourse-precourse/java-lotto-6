package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_GRADE_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_NUMBER_QUANTITY;
import static lotto.util.ConstantNumbers.MAXIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.MINIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.RESET_INTEGER_NUMBER;
import static lotto.util.ConstantNumbers.RESET_INTEGER_ONE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
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

        for (int i = RESET_INTEGER_NUMBER.getConstant(); i < count; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(
                    MINIMUM_Lotto_NUMBER.getConstant(),
                    MAXIMUM_Lotto_NUMBER.getConstant(),
                    LOTTO_NUMBER_QUANTITY.getConstant()
                )
            );

            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    public Map<Integer, Integer> checkResult (Lotto answerLotto, Integer bonusNumber) {
        Map<Integer, Integer> countResult = IntStream.rangeClosed(
                        RESET_INTEGER_ONE.getConstant(), LOTTO_GRADE_QUANTITY.getConstant())
                .boxed()
                .collect(HashMap::new, (map, key) -> map.put(key, 0), Map::putAll);

        for (Lotto lotto : randomLottoTickets) {
            Integer key = lotto.countSameNumber(answerLotto, bonusNumber);

            if (key < RESET_INTEGER_ONE.getConstant()) {
                continue;
            }

            Integer value = countResult.get(key) + 1;

            countResult.put(key, value);
        }

        return countResult;
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
