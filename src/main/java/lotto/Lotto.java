package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    // TODO: 추가 기능 구현
    // 로또 만들기
    public static Lotto generateRandomLotto(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        List<Integer> randomlotto = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) { //로또 1
            randomlotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomlotto);
        }

        return new Lotto(randomlotto);
    } //사용 예시 Lotto randomLotto = generateRandomLotto(purchaseAmount);

}
