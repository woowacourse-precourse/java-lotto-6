package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private final User repository;
    public Service() {
        this.repository = new User();
    }


    public List<List<Integer>> lottoDraw(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            repository.add(numbers);
        }
        return repository.getLottoNum();
    }

    public Lotto saveWinningNumbers(String[] split) {
        List<Integer> lottoNum = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNum);
    }

}
