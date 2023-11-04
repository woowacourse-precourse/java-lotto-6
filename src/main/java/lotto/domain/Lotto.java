package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (isContainSameNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContainSameNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.size() != set.size();
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        final int issueCount = numbers.size();
        buildNumbers(builder, issueCount);
        return builder.toString();
    }

    private void buildNumbers(final StringBuilder builder, final int issueCount) {
        builder.append("[");
        for (int currentIdx = 0; currentIdx < issueCount; currentIdx++) {
            builder.append(numbers.get(currentIdx));
            if (!isLastNumber(issueCount, currentIdx)) {
                builder.append(", ");
            }
        }
        builder.append("]");
    }

    private boolean isLastNumber(int issueCount, int currentIdx) {
        return issueCount - 1 == currentIdx;
    }
}
