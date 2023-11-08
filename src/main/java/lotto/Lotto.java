package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int TICKET_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]로또는 6개의 숫자로 이루어져야 합니다.");
        }

        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR]로또 숫자는 1부터 45 사이어야 합니다.");
            }
        }

        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto createRandomLotto() {
        List<Integer> pickedNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            int number = (int) (Math.random() * MAX_NUMBER) + 1; // Random number between 1 and 45
            while (pickedNumbers.contains(number)) {
                number = (int) (Math.random() * MAX_NUMBER) + 1;
            }
            pickedNumbers.add(number);
        }
        Collections.sort(pickedNumbers);
        return new Lotto(pickedNumbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
