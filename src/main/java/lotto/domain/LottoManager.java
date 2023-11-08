package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.LottoResultStatus;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private final int bonusLottoNumber;
    private Map<LottoResult, Integer> lottoWinningResult;

    public LottoManager(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
        this.lottoWinningResult = resetLottoWinningResult();
    }

    public Map<LottoResult, Integer> resetLottoWinningResult() {
        Map<LottoResult, Integer> lottoWinningResult = new HashMap<>();
        lottoWinningResult.put(new LottoResult(LottoResultStatus.THREE_MATCH.getMatchingNumbers(),
                LottoResultStatus.THREE_MATCH.hasBonusNumber()), 0);
        lottoWinningResult.put(new LottoResult(LottoResultStatus.FOUR_MATCH.getMatchingNumbers(),
                LottoResultStatus.FOUR_MATCH.hasBonusNumber()), 0);
        lottoWinningResult.put(new LottoResult(LottoResultStatus.FIVE_MATCH.getMatchingNumbers(),
                LottoResultStatus.FIVE_MATCH.hasBonusNumber()), 0);
        lottoWinningResult.put(new LottoResult(LottoResultStatus.FIVE_AND_BONUS_MATCH.getMatchingNumbers(),
                LottoResultStatus.FIVE_AND_BONUS_MATCH.hasBonusNumber()), 0);
        lottoWinningResult.put(new LottoResult(LottoResultStatus.SIX_MATCH.getMatchingNumbers(),
                LottoResultStatus.SIX_MATCH.hasBonusNumber()), 0);
        return lottoWinningResult;
    }

    public void countMatchingWinningLottoNumbers(LottoBuyer lottoBuyer) {
        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();

        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();

            boolean hasBonusNumber = lottoNumbers.contains(bonusLottoNumber);
            int matchingCount = (int) winningLottoNumbers.stream()
                    .filter(lottoNumbers::contains)
                    .count();

            if (matchingCount >= 3) {
                LottoResult lottoResult = new LottoResult(matchingCount, hasBonusNumber);

                if(lottoWinningResult.containsKey(lottoResult)){
                    lottoWinningResult.put(lottoResult, lottoWinningResult.get(lottoResult) + 1);
                }
//                if (!lottoWinningResult.containsKey(lottoResult)) {
//                    lottoWinningResult.put(lottoResult, 1);
//                }
            }
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusLottoNumber() {
        return bonusLottoNumber;
    }

    public Map<LottoResult, Integer> getLottoWinningResult() {
        return lottoWinningResult;
    }
}
