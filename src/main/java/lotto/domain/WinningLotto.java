package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WinningLotto {
    private List<Integer> randomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public Lotto createLotto() {
        List<Integer> intLottos = randomNumber();
        List<Integer> sortLottos = sortNumber(intLottos);
        Lotto lotto = new Lotto(sortLottos);
        return lotto;
    }
}
