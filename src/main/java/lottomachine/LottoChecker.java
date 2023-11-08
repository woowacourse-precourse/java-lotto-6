package lottomachine;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    private final List<Lotto> lottoList;
    private final Lotto winningNumber;
    private final int bonusNumber;

    public LottoChecker(List<Lotto> lottoList, Lotto winningNumber, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> checkLottos() {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int matchCount = compareLottoNumbers(lotto);
            boolean bonusMatch = compareBonusNumber(lotto);
            LottoResult result = new LottoResult(matchCount, bonusMatch);
            results.add(result);
        }
        return results;
    }

    private int compareLottoNumbers(Lotto lotto) {
        int matchCount = 0;
        boolean isValidBonus = false;
        List<Integer> numbers = lotto.getLottoNumbers();
        for (int number : numbers) {
            if (winningNumber.getLottoNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean compareBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        return numbers.contains(bonusNumber);
    }




}
