package lotto;

import java.util.List;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

        Collections.sort(this.numbers);
    }

    public void printLotto() {
        System.out.print("[");
        boolean flag = false;
        for (Integer i : numbers) {
            if (flag) {
                System.out.print(", ");
            }
            System.out.print(i);
            flag = true;
        }
        System.out.println("]");
    }

    public boolean isIncluded(int number) {
        for (int i : this.numbers) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    public int countDuplicated(Lotto other) {
        boolean[] used = new boolean[Value.RAINGE_MAX.get() + Value.ONE.get()];
        for (int i : this.numbers) {
            used[i] = true;
        }

        int count = 0;
        for (int i : other.numbers) {
            if (used[i]) {
                count++;
            }
        }
        return count;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Value.LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개여야 합니다.");
        }
        boolean[] used = new boolean[Value.RAINGE_MAX.get() + Value.ONE.get()];
        for (Integer i : numbers) {
            if (i < Value.RAINGE_MIN.get() || i > Value.RAINGE_MAX.get()) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1~45여야 합니다.");
            }
            if (used[i]) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되면 안됩니다.");
            }
            used[i] = true;
        }
    }
}
