package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.domain.enumerate.NumberType;
import lotto.domain.enumerate.Rank;
import lotto.message.ConsoleMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
    private void validateDuplicate(List<Integer> numbers) {
        HashSet set = new HashSet(numbers);
        if(set.size()!= numbers.size()){
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public Rank compare(WinningLotto winningLotto) {
        List<WinningNumber> winningNumber = winningLotto.getWinnigNumbers();
        int matchNumber = matchWinningNumber(winningNumber);
        int bonusMatch = matchBonus(winningNumber);
        return Rank.of(matchNumber, bonusMatch);
    }


    private int matchWinningNumber(List<WinningNumber> winningNumbers) {
        List<WinningNumber> withoutBonus = winningNumbers.stream()
                .filter(winNum -> winNum.getWinningType() == NumberType.ORIGINAL).toList();

        return (int) numbers.stream().filter(number -> withoutBonus.stream()
                        .anyMatch(winningNumber -> Objects.equals(winningNumber.getWinningNum(), number)))
                .count();

    }

    private int matchBonus(List<WinningNumber> winningNumbers) {
        List<WinningNumber> withoutBonus = winningNumbers.stream()
                .filter(winNum -> winNum.getWinningType() == NumberType.BONUS)
                .toList();

        return (int) numbers.stream()
                .filter(number -> withoutBonus.stream()
                        .anyMatch(winningNumber -> Objects.equals(winningNumber.getWinningNum(), number)))
                .count();
    }



}
