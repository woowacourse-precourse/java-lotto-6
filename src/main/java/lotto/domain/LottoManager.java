package lotto.domain;

import java.util.List;
import lotto.Validator.LottoValidator;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private List<Integer> matchingCounts;

    public LottoManager(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.matchingCounts = List.of();
    }

    public void countMatchingCounts(LottoBuyer lottoBuyer, LottoManager lottoManager) {
        lottoBuyer.getLottoTickets().forEach(ticket -> {
            int matchingCount = (int) lottoManager.getWinningLottoNumbers().stream()
                    .filter(ticket.getNumbers()::contains)
                    .count();
            matchingCounts.add(matchingCount);
        });
    }

    private List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

}
