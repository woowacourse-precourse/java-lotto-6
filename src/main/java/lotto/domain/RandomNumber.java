package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.LottoNumber.*;

public class RandomNumber {
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms
                .pickUniqueNumbersInRange(
                        START_LOTTO_NUMBER.getValue(),
                        END_LOTTO_NUMBER.getValue(),
                        LOTTO_SIZE.getValue()
                )
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return randomNumbers;
    }
}
