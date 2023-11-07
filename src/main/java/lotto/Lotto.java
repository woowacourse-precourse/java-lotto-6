package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = InputNumbers();
    }

    private List<Integer> InputNumbers() {
        String[] input = Console.readLine().split(",");
        List<Integer> inputNumbers = new ArrayList<>();

        for (String str : input) {
            inputNumbers.add(Integer.parseInt(str));
        }

        return inputNumbers;
    }

    public int bonusNumber() {
        int number = Integer.parseInt(Console.readLine());
        bonusNumberValidation(number);
        return number;
    }

    private void bonusNumberValidation(int number) {
        Lotto lotto = new Lotto(numbers);

        if(lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }

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
