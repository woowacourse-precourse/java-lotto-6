package lotto;

import java.util.List;

public class UserLotto {

    public List<Integer> numbers;

    public UserLotto(List<Integer> numbers) {
        this.numbers = numbers;
        sortList(numbers);
    }

    public void sortList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - 1 - i; j++) {
                check(numbers, j);
            }
        }
    }

    public void check(List<Integer> numbers, int j) {
        int left = numbers.get(j);
        int right = numbers.get(j + 1);

        if (left > right) {
            numbers.add(j, right);
            numbers.remove(j + 1);
            numbers.add(j + 1, left);
            numbers.remove(j + 2);
        }
    }
}
