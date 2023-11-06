package lotto.dto.request;

import java.util.List;

public class WinningNumbersDto {

    private final List<Integer> numbers;
    private final int bonus;

    private WinningNumbersDto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public static WinningNumbersDto of(List<Integer> numbers, int bonus) {
        return new WinningNumbersDto(numbers, bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
