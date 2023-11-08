package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private final int bonusLottoNumber;
    private Map<Integer, Boolean> matchingCounts;

    public LottoManager(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
        this.matchingCounts = new HashMap<>();
    }

    public void countMatchingWinningLottoNumbers(LottoBuyer lottoBuyer) {

        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();
        Map<Integer, Boolean> lottoWinningResults = new HashMap<>();

        lottoTickets.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            int count = (int) winningLottoNumbers.stream()
                    .filter(numbers::contains)
                    .count();
            boolean flag = numbers.contains(bonusLottoNumber);
            lottoWinningResults.put(count, flag);
        });
    }

    private List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

}
