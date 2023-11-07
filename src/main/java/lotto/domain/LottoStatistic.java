package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private final Map<LottoGrade, Integer> result = new LinkedHashMap<>();


    private void generateResult(List<Lotto> issueLottos, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        for (Lotto issueLotto : issueLottos) {
            LottoGrade lottoGrade = getMatchResult(winningNumbers, bonusNumber, issueLotto);
            addGrade(lottoGrade);
        }
    }

    private LottoGrade getMatchResult(List<Integer> winningNumbers, int bonusNumber, Lotto issueLotto) {
        List<Integer> issueNumber = issueLotto.getNumbers();
        int matchNumberCount = (int) issueNumber.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean isMatchBonus = issueNumber.contains(bonusNumber);

        return LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);
    }

    private void addGrade(LottoGrade lottoGrade) {
        result.put(lottoGrade, result.getOrDefault(lottoGrade, 0) + 1);
    }

    public Map<LottoGrade, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
