package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;

public record BuyingResult(List<Integer> singleResult) {

    public static BuyingResult createFrom(final Lotto lotto) {
        return new BuyingResult(lotto.getNumbers());
    }

    public String createSingleResultMessage() {
        return singleResult.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
