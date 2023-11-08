package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class LottoService {
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumber = sorted(numbers);
        return new Lotto(sortedNumber);
    }

    public static Prize getResult(
            Lotto lotto,
            List<Integer> winningNumbers,
            int bonusNumber)
    {
        int matchCount = lotto.match(winningNumbers);
        boolean matchBonus = lotto.match(bonusNumber);
        return Prize.getPrize(matchCount, matchBonus);
    }

    private static List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
