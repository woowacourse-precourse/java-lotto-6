package lotto.model.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.enums.LottoCount;
import lotto.utils.LottoCreator;

public class LottoServiceImpl implements LottoService {

    @Override
    public List<List<Integer>> createLotto(int lottoCount) {
        LottoCreator creator = new LottoCreator();
        creator.createLotto(lottoCount);
        return creator.getCreatedLottos();
    }

    @Override
    public Map<LottoCount, Integer> compareLottoToWinningAndBonus(List<List<Integer>> createdLottos,
                                                                  List<Integer> winningNumbers,
                                                                  int bonusNumber) {
        Map<LottoCount, Integer> resultTable = getInitializedMap();
        for (List<Integer> createdLotto : createdLottos) {
            LottoCount lottoCount = findLottoCount(createdLotto, winningNumbers, bonusNumber);

            Integer duplicatedValue = resultTable.get(lottoCount);
            resultTable.put(lottoCount, duplicatedValue + 1);
        }
        return Collections.unmodifiableMap(resultTable);
    }

    @Override
    public long getTotalWinningPrice(Map<LottoCount, Integer> lottoResult) {
        long totalWinningPrice = 0;
        for (LottoCount lottoCount : lottoResult.keySet()) {
            long price = lottoCount.getPrice();
            Integer count = lottoResult.get(lottoCount);
            totalWinningPrice += (price * count);
        }
        return totalWinningPrice;
    }

    private LottoCount findLottoCount(List<Integer> createdLotto,
                                      List<Integer> winningNumbers,
                                      int bonusNumber) {
        long duplicatedCount = createdLotto.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonus = createdLotto.contains(bonusNumber);
        // 5개 일치 + 보너스 번호 일치하면 BONUS 상수로 구분
        if (duplicatedCount == 5 && hasBonus) {
            return LottoCount.BONUS;
        }
        return LottoCount.findByCount(duplicatedCount);
    }

    private Map<LottoCount, Integer> getInitializedMap() {
        Map<LottoCount, Integer> resultTable = new HashMap<>();
        for (LottoCount lottoCount : LottoCount.values()) {
            resultTable.put(lottoCount, 0);
        }
        return resultTable;
    }
}
