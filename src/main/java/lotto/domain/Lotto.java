package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.view.ErrorMessage;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
        validateDuplicationNumber(numbers);
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    @Override
    public String toString(){
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_LOTTO_NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);

        if(numbers.size() != set.size()){
            throw new IllegalArgumentException();
        }
    }
}
