package lotto.domain;

import lotto.utils.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private List<Integer> winningNumber;
    public WinningNumber(String winningNumber){
        Validator.checkWinningNumber(parseInteger(winningNumber));
        this.winningNumber = parseInteger(winningNumber);
    }

    private List<Integer> parseInteger(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(part -> part.replaceAll("\\s+", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
