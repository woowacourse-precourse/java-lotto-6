package lotto.domain;

import lotto.service.GameService;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        // 검증 로직
        this.numbers = GameService.createWinningNumbers(numbers);
    }

    public List<Integer> getNumber() {
        return numbers;
    }
}