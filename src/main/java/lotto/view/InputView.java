package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPrice;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public LottoPrice getLottoPrice() {
        String input = Console.readLine();
        return new LottoPrice(input);
    }

    public List<Integer> getWinningNumbers() {
        String line = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(number -> number >= 1 && number <= 45)
                .toList();
        if (winningNumbers.size() != Arrays.stream(line.split(",")).count()) {
            throw new IllegalArgumentException();
        }
        return winningNumbers;
    }
}
