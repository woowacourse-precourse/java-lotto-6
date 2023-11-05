package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.util.Constants;

public class LottoStatistics {
    private List<Lotto> userLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private LottoService lottoService;

    private long totalRevenue = 0;

    public LottoStatistics(LottoService lottoService, List<Lotto> userLottos, List<Integer> winningNumbers,
                           int bonusNumber) {
        this.lottoService = lottoService;
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> calculateWinsPerCategory() {
        int[] wins = new int[LottoRank.values().length];

        for (Lotto lotto : userLottos) {
            LottoRank rank = lottoService.checkWinning(lotto.getNumbers(), winningNumbers, bonusNumber);
            totalRevenue += rank.getPrize();
            wins[rank.ordinal()]++;
        }

        List<Integer> winsPerCategory = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            winsPerCategory.add(wins[rank.ordinal()]);
        }

        return winsPerCategory;
    }

    public double calculateRateOfReturn() {
        double purchaseAmount = userLottos.size() * Constants.LOTTO_PRICE;
        return Math.round((totalRevenue / purchaseAmount - 1) * 100) / 100.0;
    }
}
