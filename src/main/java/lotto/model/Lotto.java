package lotto.model;

import static lotto.constants.LottoConstants.NUMBER_OF_LOTTO_NUMBERS;

import java.util.List;
import lotto.converter.MessageConverter;
import lotto.model.dto.WinningNumDTO;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    public String writePurchasedLotto() {
        return MessageConverter.writePurchasedLotto(numbers);
    }

    public Ranking checkResult(WinningNumDTO winningNumDTO) {
        int correct = getNumOfCorrect(winningNumDTO.getWinningNums());
        return Ranking.of(correct, isBonus(winningNumDTO.getBonus()));
    }

    private int getNumOfCorrect(List<Integer> winningNums) {
        return (int) winningNums.stream().filter(num -> numbers.contains(num)).count();
    }

    private boolean isBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
