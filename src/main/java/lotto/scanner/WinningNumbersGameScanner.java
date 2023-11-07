package lotto.scanner;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningNumbers;

public class WinningNumbersGameScanner implements GameScanner<WinningNumbers> {

    @Override
    public WinningNumbers scan() {
        String scannedValue = Console.readLine();
        List<Integer> value = parse(scannedValue);

        return new WinningNumbers(value);
    }

    private List<Integer> parse(String scannedValue) {
        List<Integer> value = Arrays.stream(scannedValue.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return value;
    }
}
