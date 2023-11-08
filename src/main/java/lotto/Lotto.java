package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private List<Integer> select_numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;


            }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        for (Integer number : select_numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();

    }

    // TODO: 추가 기능 구현
}
