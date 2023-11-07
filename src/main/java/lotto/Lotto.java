//Lotto.java
package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.Enum.ErrorMessage;

public class Lotto {
    //Lotto에 인스턴스 변수 추가 불가
    //패키지 변경은 가능

    //private 변경 금지
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RIGHT_LOTTO_SIZE.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_NUMBER.getMessage());
        }

    }

    public String toString(){
        List<String> numberStrings = numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.toList());
        return "[" + String.join(", ", numberStrings) + "]";
    }

    public boolean have(Integer numberToFind){
        return this.numbers.contains(numberToFind);
    }
}
