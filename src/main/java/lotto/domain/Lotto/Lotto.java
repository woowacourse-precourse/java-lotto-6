package lotto.domain.Lotto;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = new ArrayList<>();
        sortLottoNumbers(new ArrayList<>(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        for (int i = 0; i < 6; i++) {
            this.numbers.add(numbers.get(i));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void checkDuplicate(List<Integer> numbers) {
        Set<Integer> numberWithoutDuplicate = new HashSet<>(numbers);
        if (numbers.size() != numberWithoutDuplicate.size()) {
            System.out.println("[ERROR] 로또의 숫자는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

}
