package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sameNumber(List<Integer> numbers) {
        List<Integer> numCheck = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++){
            if(numCheck.contains(numbers.get(i))) continue;
            numCheck.add(numbers.get(i));
        }

        validate(numCheck);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumber(List<Integer> numbers){
        int[] num = new int[numbers.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = numbers.get(i);
        }

        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
