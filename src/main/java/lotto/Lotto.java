package lotto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import message.Symbol;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        StringBuilder lotteryNumbers = new StringBuilder();
        lotteryNumbers.append(Symbol.OPEN_SQUARE_BRACKET.getSymbol());
        lotteryNumbers.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Symbol.COMMA.getSymbol() + Symbol.SPACE.getSymbol())));
        lotteryNumbers.append(Symbol.CLOSE_SQUARE_BRACKET.getSymbol());
        return lotteryNumbers.toString();
    }

    public Optional<Rank> getRank(List<Integer> winningNumbers, int bonusNumber) {
        return Rank.getRank(numbers, winningNumbers, bonusNumber);
    }
}
