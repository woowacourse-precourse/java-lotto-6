package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input) {
        List<Integer> inputNumbers = changeStringToLotto(input);
        validate(inputNumbers);
        this.numbers = inputNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> changeStringToLotto(String input) {
        List<String> splitedInput = Arrays.asList(input.split(","));
        splitedInput.replaceAll(String::trim);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String inputNumber : splitedInput) {
            try {
                int number = Integer.parseInt(inputNumber);
                inputNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return inputNumbers;
    }

    public int getSize() {
        return numbers.size();
    }

    public int getItem(int idx) {
        return numbers.get(idx);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto other = (Lotto) obj;
        return numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
