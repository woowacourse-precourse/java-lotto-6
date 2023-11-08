package lotto;

import view.ExceptionView;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void duplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if(set.size() != numbers.size()){
            ExceptionView.validateDuplication();
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public String getLotto(Lotto lotto) {
        List<Integer> list = lotto.numbers;
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return Arrays.toString(arr);
    }


    public List<Integer> size() {
        return numbers;
    }
}
