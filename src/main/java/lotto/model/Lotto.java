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

    public List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> createRank() {
        return new ArrayList<>(6);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> createLottos(int calculateLottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < calculateLottoCount; i++) {
            List<Integer> lotto = createRandomLottoNumber();
            lottos.add(lotto);
        }
        return lottos;
    }

    // TODO: 추가 기능 구현
}
