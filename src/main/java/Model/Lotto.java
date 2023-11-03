package Model;

import java.util.*;

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
        validate6numbers(numbers);
        validate1to45(numbers);
        validateNotEqual(numbers);
    }

    private void validate6numbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate1to45(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNotEqual(List<Integer> numbers) {
        Set<Integer> numbersNotSame = new HashSet<>();
        for (int number : numbers) {
            if (!numbersNotSame.add(number)) {
                throw new IllegalArgumentException();
            }
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
