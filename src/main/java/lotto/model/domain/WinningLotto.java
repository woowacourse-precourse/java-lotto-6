package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private Bonus bonusNumber;

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

    public void addBonus(Bonus bonus) {
        this.bonusNumber = bonus;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

}
