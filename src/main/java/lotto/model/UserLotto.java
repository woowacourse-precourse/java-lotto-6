package lotto.model;

import static lotto.config.LottoConfig.LOTTO_VALUE_SIZE;
import static lotto.config.LottoConfig.LOTTO_VALUE_MIN;
import static lotto.config.LottoConfig.LOTTO_VALUE_MAX;
import static lotto.config.LottoConfig.LOOP_INITIAL_VALUE;
import static lotto.config.LottoConfig.ONE;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private List<List<Integer>> userNumbers = new ArrayList<>();

    public UserLotto(int lottoQuantity) {
        autoSelectLotto(lottoQuantity);
    }

    private void autoSelectLotto(int lottoQuantity) {
        while (lottoQuantity > LOOP_INITIAL_VALUE.getValue()) {
            userNumbers.add(randomPickNumber());
            lottoQuantity--;
        }
    }

    private List<Integer> randomPickNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        do {
            randomNumbers.add(Randoms.pickNumberInRange(LOTTO_VALUE_MIN.getValue(), LOTTO_VALUE_MAX.getValue()));

            List<Integer> distinctNumbers = randomNumbers.stream()
                    .distinct()
                    .toList();

            if (distinctNumbers.size() != randomNumbers.size()) {
                randomNumbers.remove(randomNumbers.size() - ONE.getValue());
            }
        } while (randomNumbers.size() < LOTTO_VALUE_SIZE.getValue());
        return randomNumbers;
    }

    public List<List<Integer>> getUserNumbers() {
        return new ArrayList<>(userNumbers);
    }
}