package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        String ticketNumbers = numbers.stream().map(t -> t.toString()).collect(Collectors.joining(","));
        Validation.emptyCheck(ticketNumbers);
        Validation.commaCheck(ticketNumbers);
        Validation.split6Check(ticketNumbers);
        Validation.range1to45Check(ticketNumbers);
        Validation.ticketNumberDuplecationCheck(ticketNumbers);
    }

    List<Integer> toList() {
        return this.numbers;
    }
}