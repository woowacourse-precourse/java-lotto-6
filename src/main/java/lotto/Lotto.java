package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if(existDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        if(!validateRange(numbers)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean existDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(i) == numbers.get(j)) return true;
            }
        }
        return false;
    }


    private boolean validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(!(1 <= number && number <= 45)) return false;
        }

        return true;
    }

    public String printNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        System.out.println(sb);
        return sb.toString();
    }

}
