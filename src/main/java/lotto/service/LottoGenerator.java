package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoGenerator {
    public static WinningLotto generateWinningLotto(String input, int bonusNumber) {
        List<Integer> list = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        return new WinningLotto(list, bonusNumber);
    }

    public static Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
