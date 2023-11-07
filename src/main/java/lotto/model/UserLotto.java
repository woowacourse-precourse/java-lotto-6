package lotto.model;

import static lotto.config.LottoConfig.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private final List<List<Integer>> userLottoNumbers = new ArrayList<>();

    public UserLotto(int lottoQuantity) {
        autoSelectLotto(lottoQuantity);
    }

    private List<Integer> sortedUserLottoNumbers(List<Integer> randomPickNumbers) {
        return randomPickNumbers.stream().sorted().collect(Collectors.toList());
    }

    private void autoSelectLotto(int lottoQuantity) {
        while (lottoQuantity > ZERO.getValue()) {
            userLottoNumbers.add(sortedUserLottoNumbers(randomPickNumber()));
            lottoQuantity--;
        }
    }

    private List<Integer> randomPickNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        do {
            randomNumbers.add(Randoms.pickNumberInRange(LOTTO_VALUE_MIN.getValue(), LOTTO_VALUE_MAX.getValue()));

            if (isDuplicate(randomNumbers)) {
                randomNumbers.remove(randomNumbers.size() - ONE.getValue());
            }
        } while (randomNumbers.size() < LOTTO_VALUE_SIZE.getValue());
        return randomNumbers;
    }

    private boolean isDuplicate(List<Integer> randomNumbers) {
        List<Integer> distinctRandomNumbers = randomNumbers.stream()
                .distinct()
                .toList();

        if (distinctRandomNumbers.size() != randomNumbers.size()) {
            return true;
        }
        return false;
    }

    public List<List<Integer>> getUserLottoNumbers() {
        return new ArrayList<>(userLottoNumbers);
    }
}