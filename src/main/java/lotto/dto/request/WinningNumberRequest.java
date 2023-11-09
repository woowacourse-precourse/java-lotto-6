package lotto.dto.request;

import java.util.List;

public class WinningNumberRequest {
    private final List<Integer> numbers;

    public WinningNumberRequest(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
