package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = InputMatchedNumbers();
    }

    public List<Integer> InputMatchedNumbers() {
        String[] a = Console.readLine().split(",");
        List<Integer> b = new ArrayList<>();

        for (String str : a) {
            b.add(Integer.parseInt(str));
        }

        b.add(bonusNumber());
        return b;
    }

    public int bonusNumber () {
        return Integer.parseInt(Console.readLine());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
