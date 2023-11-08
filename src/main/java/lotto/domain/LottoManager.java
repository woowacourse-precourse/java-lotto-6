package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private final int bonusLottoNumber;
    private List<LottoResult> lottoResults;

    public LottoManager(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
        this.lottoResults = List.of();
    }

    public void countMatchingWinningLottoNumbers(LottoBuyer lottoBuyer) {

        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();

        lottoTickets.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            int matchingNumbers = (int) winningLottoNumbers.stream()
                    .filter(numbers::contains)
                    .count();
            boolean hasBonusNumber = numbers.contains(bonusLottoNumber);

            if (matchingNumbers >= 3) {
                lottoResults.add(new LottoResult(matchingNumbers, hasBonusNumber));
            }
        });
    }

    private List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

}
