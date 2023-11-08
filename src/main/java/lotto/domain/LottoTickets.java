package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.Rank;
import lotto.utils.LottoNumbersGenerator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(int numberOfTickets) {
        validateNumber(numberOfTickets);
        this.lottoTickets = generateRandomLottoTickets(numberOfTickets);
    }

    public static LottoTickets createdByNumber(int numberOfTickets) {
        return new LottoTickets(numberOfTickets);
    }

    public List<Lotto> getLottoTickets() {
        return this.lottoTickets;
    }

    private void validateNumber(int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
    }

    private List<Lotto> generateRandomLottoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(i -> Lotto.valueOf(LottoNumbersGenerator.generate()))
                .toList();
    }

    public Map<Rank, Integer> calculateWinningResult(WinningLotto winningLotto) {
        if(winningLotto == null) {
            throw new IllegalStateException("[ERROR] winningLotto가 null인 상태 이므로 계산이 불가능 합니다.");
        }
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottoTickets) {
            Rank rank = winningLotto.match(lotto);
            if (rank == null) continue;
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return winningResult;
    }
}
