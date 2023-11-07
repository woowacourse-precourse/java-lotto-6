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
    private long totalRevenue;
    private final List<Integer> winsPerCategory;
    private final double totalRate;

    public LottoStatistics(List<Lotto> userLottos, List<Integer> winningNumbers,
                           int bonusNumber) {
        this.lottoService = LottoService.getInstance();
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        winsPerCategory = calculateWinsPerCategory();
        totalRate = calculateRateOfReturn();
        totalRevenue = 0;
    }

    public List<Integer> getWinsPerCategory() {
        return winsPerCategory;
    }

    public double getTotalRate() {
        return totalRate;
    }

    private List<Integer> calculateWinsPerCategory() {
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

    private double calculateRateOfReturn() {
        double purchaseAmount = userLottos.size() * Constants.LOTTO_PRICE;
        return totalRevenue / purchaseAmount;
    }
}