package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {return numbers;}
    public String toString() {
        List<String> numbersForPrint = new ArrayList<>();
        for (int i : numbers) {
            numbersForPrint.add(Integer.toString(i));
        }
        String lottoTicket = "[" + String.join(", ", numbersForPrint) + "]";
        return lottoTicket;
    }


}
