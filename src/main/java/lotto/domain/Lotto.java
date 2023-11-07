package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.view.ErrorMessage;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_LOTTO_NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    @Override
    public String toString(){
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
