package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
    }

    private List<List<Integer>> generateLotto(int quantity) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(randomNumbers);
        }
        return lottos;
    }


    // TODO: 추가 기능 구현
}
