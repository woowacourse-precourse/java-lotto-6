package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class Generator {
    public static List<Lotto> publishTickets(int ticketAmount) {
        return IntStream.range(0, ticketAmount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lotto = Sorter.sort(numbers);
        return new Lotto(lotto);
    }
}
