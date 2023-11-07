package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class LottoService {
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sorted(numbers);
        return new Lotto(numbers);
    }

    public static Prize getResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        if (lotto.match(winningNumbers) == 6) {
            return Prize.FIRST;
        }
        if (lotto.match(winningNumbers) == 5 && lotto.match(bonusNumber)) {
            return Prize.SECOND;
        }
        if (lotto.match(winningNumbers) == 5) {
            return Prize.THIRD;
        }
        if (lotto.match(winningNumbers) == 4) {
            return Prize.FOURTH;
        }
        if (lotto.match(winningNumbers) == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    private static List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
