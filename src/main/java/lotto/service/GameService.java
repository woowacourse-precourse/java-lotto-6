package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {

    public List<Integer> createLottoNumbers() {
        return IntStream.range(0, 6)
                .map(i -> randomNumber())
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public int randomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
