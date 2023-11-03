package lotto.model;

import lotto.utils.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private Lotto winningNumber;

    private WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber from(String[] inputNumbers) {
        List<Integer> winningNumber = Util.stringToIntegerList(inputNumbers);
        return new WinningNumber(new Lotto(winningNumber));
    }
}
