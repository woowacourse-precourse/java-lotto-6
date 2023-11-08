package lotto.module.application;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.global.constant.WinAmount;
import lotto.module.domain.Lotto;
import org.assertj.core.util.Lists;

public class LottoService {

    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    public List<Lotto> generateLottoList(int count) {
        List<Lotto> lottoList = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }

        return lottoList;
    }

    public Map<Long, Integer> getStaticsMap(List<Lotto> userLottoList, Lotto winLotto, Integer bonusNumber) {
        Map<Long, Integer> statics = new HashMap<>();
        for (Lotto userLotto : userLottoList) {
            long winCount = userLotto.findWinCount(winLotto, bonusNumber);
            // 미당첨 게임은 Pass
            if (winCount == 0) {
                continue;
            }
            int count = statics.getOrDefault(winCount, 0);

            statics.put(winCount, ++count);
        }

        return statics;
    }

    public long calcTotalWinAmount(Map<Long, Integer> statics) {
        long totalAmount = 0L;
        for (Map.Entry<Long, Integer> item : statics.entrySet()) {
            long winAmount = WinAmount.findWinAmount(item.getKey());
            totalAmount += winAmount * item.getValue();
        }

        return totalAmount;
    }

    public String calcRate(long totalWinAmount, Integer buyAmount) {
        return String.format("%,.1f", (totalWinAmount / buyAmount.doubleValue()) * 100);
    }
}