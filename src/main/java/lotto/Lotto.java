package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }

        if(existDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

        if(!validateRange(numbers)) {
            throw new IllegalArgumentException("1 ~ 45범위의 숫자만 가질 수 있습니다.");
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
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        int deleteIndex = sb.lastIndexOf(",");
        sb.delete(deleteIndex, deleteIndex + 2);
        sb.append("]");
        System.out.println(sb);
        return sb.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
