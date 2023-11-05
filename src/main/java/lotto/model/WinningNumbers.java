package lotto.model;

import lotto.dto.request.WinningNumbersDto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    private WinningNumbers(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningNumbers from(WinningNumbersDto winningNumbersDto) {
        return new WinningNumbers(winningNumbersDto.getNumbers(), winningNumbersDto.getBonus());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getBonus() {
        return bonus;
    }
}
