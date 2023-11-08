package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> vaildNumbers = new ArrayList<>(numbers);
        Collections.sort(vaildNumbers);
        this.numbers = vaildNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    String.format("로또는 6개의 숫자를 갖고 있습니다. 입력하신 숫자는: %s", numbers)
            );
        }
    }

    public void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::Range)) {
            throw new IllegalArgumentException(
                    String.format("로또는 1 ~ 45 사이의 숫자만을 허용합니다. 입력하신 숫자는: %s", numbers)
            );
        }
    }

    public boolean Range(int number) {
        return 1 > number || number > 46;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (Duplicate(numbers)) {
            throw new IllegalArgumentException(
                    String.format("로또는 중복된 숫자를 허용하지 않습니다. 입력하신 숫자는: %s", numbers)
            );
        }
    }

    public boolean Duplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public List<Integer> cloneNumbers(){
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}
