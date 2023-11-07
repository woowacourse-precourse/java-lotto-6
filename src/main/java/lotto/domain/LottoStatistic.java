package lotto.domain;

import java.util.*;

public class LottoStatistic {
    private final Map<LottoGrade, Integer> result = new LinkedHashMap<>();

    public LottoStatistic(List<Lotto> issueLottos, WinningLotto winningLotto) {
        initLottoRankCountMap();
        generateResult(issueLottos, winningLotto);
    }

    private void initLottoRankCountMap() {
        result.put(LottoGrade.FIRST, 0);
        result.put(LottoGrade.SECOND, 0);
        result.put(LottoGrade.THIRD, 0);
        result.put(LottoGrade.FOURTH, 0);
        result.put(LottoGrade.FIFTH, 0);
    }

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

    public double getAllReturnRate(int lottoPurchaseAmount) {
        int totalPrize = LottoGrade.getTotalPrize(result);
        return ((double) totalPrize / lottoPurchaseAmount) * 100;
    }
}
