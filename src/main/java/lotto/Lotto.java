package lotto;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 다릅니다.");
        }
        List<Integer> uniqueNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
            }
            uniqueNumbers.add(number);
        });
    }

    public String sayNumbers() {
        ArrayList<Integer> sortableNumbers = new ArrayList<>(numbers);
        Collections.sort(sortableNumbers);
        String numberLine = sortableNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        return MessageFormat.format("[{0}]", numberLine);
    }

    // TODO: 추가 기능 구현
}
