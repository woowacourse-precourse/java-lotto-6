package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numberSort(numbers);
        System.out.println(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 개수가 초과 되었습니다.");
        }
        List<Integer> newList = numbers.stream().distinct().toList();
        if (numbers.size() != newList.size()) {
            throw new IllegalArgumentException("[ERROR] 번호가 중복 됩니다.");
        }
        for (Integer n : numbers) {
            if (n < 0) {
                throw new InputMismatchException("[ERROR] 번호에는 음수가 들어갈 수 없습니다.");
            }
            if (n > 45) {
                throw new InputMismatchException("[ERROR] 번호의 최대값은 45입니다..");
            }
        }
    }

    //리스트 오름차순 정렬 코드
    private List<Integer> numberSort(List<Integer> numbers) {
        List<Integer> num = new ArrayList<>(numbers);
        Collections.sort(num);
        return num;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
