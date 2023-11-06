package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private final Repository repository;
    public Service() {
        this.repository = new Repository();
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
