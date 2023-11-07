package lotto;

import java.util.HashSet; import java.util.List; import java.util.Set;

import static java.lang.Integer.parseInt;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        } else if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        for(int number : numbers) {
            if(number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
