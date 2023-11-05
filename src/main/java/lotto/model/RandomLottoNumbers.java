package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static java.util.stream.IntStream.*;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_GRADE_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_NUMBER_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_SECOND_MONEY;
import static lotto.util.ConstantNumbers.MAXIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.MINIMUM_Lotto_NUMBER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class RandomLottoNumbers {

    private final List<Lotto> randomLottoTickets;

    private RandomLottoNumbers(Integer count) {
        this.randomLottoTickets = createRandomLottoNumbers(count);
    }

    public static RandomLottoNumbers of(Integer count) {
        return new RandomLottoNumbers(count);
    }

    private List<Lotto> createRandomLottoNumbers(Integer count) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(
                    pickUniqueNumbersInRange(MINIMUM_Lotto_NUMBER.getConstant(), MAXIMUM_Lotto_NUMBER.getConstant(),
                            LOTTO_NUMBER_QUANTITY.getConstant()));

            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    public Map<Integer, Integer> checkResult(Lotto answerLotto, Integer bonusNumber) {
        Map<Integer, Integer> countResult = rangeClosed(0, LOTTO_GRADE_QUANTITY.getConstant() - 1).boxed()
                .collect(HashMap::new, (map, key) -> map.put(key, 0), Map::putAll);

        for (Lotto lotto : randomLottoTickets) {
            Integer countNumber = lotto.countSameNumber(answerLotto);

            if (countNumber < LOTTO_FIFTH_QUANTITY.getConstant()) {
                continue;
            }

            Integer key = generateKey(countNumber, lotto.hasBonusNumber(bonusNumber));
            Integer value = countResult.get(key) + 1;

            countResult.put(key, value);
        }

        return countResult;
    }

    private Integer generateKey (Integer countNumber, Boolean ifHasBonusNumber) {

        if (countNumber.equals(LOTTO_FIRST_QUANTITY.getConstant())) {
            return LOTTO_FIRST_QUANTITY.getConstant() - 2;
        }

        if (countNumber.equals(LOTTO_SECOND_MONEY.getConstant()) && ifHasBonusNumber) {
            return LOTTO_SECOND_MONEY.getConstant() - 2;
        }

        return countNumber - LOTTO_FIFTH_QUANTITY.getConstant();
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
