package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private Player player;
    private LottoResult lottoResult = LottoResult.NONE;
    private Map<LottoResult, Integer> lottoResultWithCount = new HashMap<>();
    private int total = 0;

    public Lottos(List<Integer> winningNumber, int bonusNumber, Player player) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.player = player;
    }

    public void classifyLottoGrade() {
        for (int i = 0; i < player.getLotteries().size(); i++) {
            List<Integer> result = calculateMatchNumbers(i);
            int size = result.size();
            if (size == 5 && isBonusNumberIncluded(i)) {
                size += 5;
            }
            this.lottoResult = LottoResult.initiateLottoResult(size);
            addCount(lottoResult);
            total += LottoResult.calculateRate(lottoResultWithCount, lottoResult);
        }
        System.out.println(total);
    }

    private void addCount(LottoResult lottoResult) {
        lottoResultWithCount.put(lottoResult, lottoResultWithCount.getOrDefault(lottoResult, 0) + 1);
    }

    private List<Integer> calculateMatchNumbers(int index) {
        return winningNumber.stream()
                .filter(num -> player.getLotteries()
                .get(index)
                        .getNumbers()
                        .stream()
                .anyMatch(Predicate.isEqual(num)))
                .collect(Collectors.toList());
    }

    private boolean isBonusNumberIncluded(int index) {
        return player.getLotteries().get(index).getNumbers().contains(bonusNumber);
    }
}
