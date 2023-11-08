package lotto;

import java.util.List;
import java.util.Comparator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void printLotto() {
        boolean[] used = new boolean[Value.RAINGE_MAX.get() + Value.ONE.get()];
        for (Integer i : numbers) {
            used[i] = true;
        }
        System.out.print("[");
        boolean flag = false;
        for (int i = Value.RAINGE_MIN.get(); i <= Value.RAINGE_MAX.get(); ++i) {
            if (flag && used[i]) {
                System.out.print(", ");
            }
            if (used[i]) {
                System.out.print(i);
                flag = true;
            }
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
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX.get());
        }
        boolean[] used = new boolean[Value.RAINGE_MAX.get() + Value.ONE.get()];
        for (Integer i : numbers) {
            if (i < Value.RAINGE_MIN.get() || i > Value.RAINGE_MAX.get()) {
                throw new IllegalArgumentException(ErrorMessage.RAINGE_MESSAGE.get());
            }
            if (used[i]) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_IN.get());
            }
            used[i] = true;
        }
    }
}
