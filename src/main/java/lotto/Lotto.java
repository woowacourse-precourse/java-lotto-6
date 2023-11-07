package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
   // private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        inRangeCheck(numbers);
        this.numbers = numbers;
       // this.bonusNumber = bonusNumber;
    
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 입력된 숫자가 6개가 아닙니다!.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != 6) {
            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void inRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (0 >= number && number <= 46) {
                System.out.println("[ERROR] 1부터 45까지의 숫자를 입력해주시요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public ArrayList<Integer> getWinningNumbers() {
        ArrayList<Integer> returnNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            returnNumbers.add(num);
        }
        
        return returnNumbers;
    }
}
