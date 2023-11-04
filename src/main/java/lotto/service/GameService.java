package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {
    public static List<Integer> createWinningNumbers(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

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
