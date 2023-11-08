package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        isValueInRange(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = Collections.unmodifiableList(sortedNumbers);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 숫자 6개를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void duplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println("[ERROR] 중복 숫자를 제거해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void isValueInRange(List<Integer> numbers){
        for (int number : numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 1~45 사이의 숫자 6자리를 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getRandomNumber() {
        return numbers;
    }

    public int getNumber(int index) {
        if (index < 0 || index >= numbers.size()) {
            throw new IllegalArgumentException("유효하지 않은 인덱스입니다.");
        }
        return numbers.get(index);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
