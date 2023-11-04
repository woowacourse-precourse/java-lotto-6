package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultDetails {

    private final Map<Rank, Integer> resultDetails = new HashMap<>();

    public ResultDetails() {
        initializeWinningCountsForRanks();
    }

    public void updateWinningResults(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        lottoTicket.getLottos().stream()
                .map(winningNumbers::findRank)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((rank, count) -> resultDetails.put(rank, count.intValue()));
    }

    private void initializeWinningCountsForRanks() {
        Arrays.stream(Rank.values())
                .forEach(rank -> resultDetails.put(rank, 0));
    }
}
