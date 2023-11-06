package lotto.service;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberService {

    public Lotto splitString(String number) {
        List<Integer> winningNumber = Arrays.stream(number.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return new Lotto(winningNumber);
    }
}
