package lotto.domain;

import javax.swing.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public int compare(Lotto player){
        List<Integer> playerNumbers = player.numbers;
        playerNumbers.retainAll(numbers);
        return playerNumbers.size();
    }

    // TODO: 추가 기능 구현
}
