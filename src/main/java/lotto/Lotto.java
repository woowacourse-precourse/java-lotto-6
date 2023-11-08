package lotto;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 수여야 합니다.");
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    //로또 번호 생성
    public static Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    //당첨 번호와 맞는 번호의 개수를 반환
    public int match(Lotto winningLotto) {
        int matchingNumbers = 0;

        for (Integer number : winningLotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }

}
