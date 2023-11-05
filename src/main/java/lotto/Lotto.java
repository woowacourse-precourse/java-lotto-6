package lotto;

import java.util.List;

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
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int calculateIssueCount(int purchaseAmount) {
        final int oneLottoPrice = 1000;
        int issueCount = 0;

        issueCount = purchaseAmount / oneLottoPrice;

        return issueCount;
    }
}
