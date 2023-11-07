package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkDuplicateNumber();
        sortNumber();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != ConstantValue.six) {
            throw new IllegalArgumentException("[ERROR] 로또번호 6자리 아님.");
        }
    }

    private void checkDuplicateNumber() {
        Set<Integer> number = toSet();
        if (number.size() < ConstantValue.six) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 있음.");
        }
    }

    public String toString() {
        String lottoNumber = String.join(", ", String.valueOf(numbers));
        return lottoNumber;
    }

    public int[] toIntegerArr() {
        int[] lottoNumber = new int[ConstantValue.six];
        for (int i = 0; i < numbers.size(); i++) {
            lottoNumber[i] = numbers.get(i);
        }
        return lottoNumber;
    }

    public Set<Integer> toSet() {
        Set<Integer> lotto = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            lotto.add(numbers.get(i));
        }
        return lotto;
    }

    public void sortNumber() {
        Collections.sort(this.numbers);
    }
    // TODO: 추가 기능 구현
}
