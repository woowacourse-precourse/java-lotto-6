package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancyCheck(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 정확하게 6개의 숫자가 입력되어야 합니다.");
        }
    }

    private void redundancyCheck(List<Integer> numbers){
        List<Integer> check = numbers.stream().distinct().collect(Collectors.toList());
        try {
            validate(check);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자는 모두 달라야 합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}

enum LottoRank{
}
