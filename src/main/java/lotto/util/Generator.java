package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class Generator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Lotto> publishTickets(int ticketAmount) {
        return IntStream.range(0, ticketAmount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        List<Integer> lotto = Sorter.sort(numbers);
        return new Lotto(lotto);
    }
}
