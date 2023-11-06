package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.CommandLine.showln;

public class LottoGenerateMachine {
    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public LottoGenerateMachine(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public List<Lotto> generate(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = generateSortedRandomLottoNumbers();
            showln(numbers.toString());
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private List<Integer> generateSortedRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        startInclusive,
                        endInclusive,
                        count
                ).stream()
                .sorted()
                .toList();
    }

}
