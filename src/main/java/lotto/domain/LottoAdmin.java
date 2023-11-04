package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAdmin {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    private List<Integer> winningNumber;

    public void inputWinningNumber() {
        String result = Console.readLine();
        validateInput(result);
        this.winningNumber = Stream.of(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInput(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
