package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

}

//    public static Lotto generateRandomLotto() {
//        List<Integer> randomNumbers = new ArrayList<>();
//        Randoms random = new Random();
//
//        while (randomNumbers.size() < 6) {
//            int number = random.nextInt(45) + 1;
//            if (!randomNumbers.contains(number)) {
//                randomNumbers.add(number);
//            }
//        }
//
//        return new Lotto(randomNumbers);
//    }

