package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoService {

    private final List<Lotto> lottoContainer;

    public LottoService(List<Lotto> lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    public void addLotto(Lotto lotto) {
        lottoContainer.add(lotto);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottoContainer);
    }

    public int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumbers = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)){
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }

    public int countMatchingBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }

    public Rank getLottoRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumbers = countMatchingNumbers(lotto, winningNumbers);
        int matchingBonusNumber = countMatchingBonusNumber(lotto, bonusNumber);
        Rank rank = Rank.getRank(matchingNumbers, matchingBonusNumber);
        return rank;
    }
}
