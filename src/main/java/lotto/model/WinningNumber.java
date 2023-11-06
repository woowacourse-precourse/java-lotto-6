package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    Lotto answer;
    public WinningNumber(String winningNumber) {
        List<Integer> lotto
                = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        answer = new Lotto(lotto);
    }

    @Override
    public boolean equals(Object expectedNumbers){
        return answer.equals(expectedNumbers);
    }
}
