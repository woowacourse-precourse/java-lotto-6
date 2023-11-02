package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Parser;

public class WinningNumber {
    private final Lotto winningNumber;
    private int bonusNumber;

    private WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    };

    public static WinningNumber create(String inputWinningNumber) {
        List<Integer> numbers = Parser.splitByComma(inputWinningNumber)
                .stream()
                .map(Parser::StringParseInt)
                .collect(Collectors.toList());
        return new WinningNumber(new Lotto(numbers));
    }
}
