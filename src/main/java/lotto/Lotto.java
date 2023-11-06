package lotto;

import java.util.ArrayList;
import java.util.List;

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
        if (!checkSameNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkSameNumber(List<Integer> numbers) {
        for(int number : numbers) {
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(numbers);
            copyList.remove(copyList.indexOf(number));
            if(copyList.contains(number)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        // 출력 형식 구현
        List<String> convertList = new ArrayList<>();
        for(Integer i : numbers) {
            convertList.add(i.toString());
        }

        String output = "[";
        output += String.join(", ", convertList);
        output += "]";
        return output;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
