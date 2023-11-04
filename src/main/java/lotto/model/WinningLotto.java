package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(String numbers) {
        this.numbers = parseInput(numbers);
    }

    private List<Integer> parseInput(String numbers) {
        List<Integer> parsedList = new ArrayList<>();
        String[] parsed = numbers.split(",");

        for(String stringInput : parsed) {
            parsedList.add(Integer.parseInt(stringInput));
        }
        return parsedList;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
