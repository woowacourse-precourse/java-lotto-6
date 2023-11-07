package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.config.Config;
import lotto.config.LottoRank;
import lotto.model.Lotto;
import lotto.model.User;

public class RankService {
    private final User user;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] winningCount;

    public RankService(User user, List<Integer> winningNumbers, int bonusNumber) {
        this.user = user;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        winningCount = new int[Config.RANK_LOTTO];
    }

    public int[] calculateLottoRanks() {
        for (Lotto lotto : user.getLottos()) {
            LottoRank rank = calculateLottoRank(lotto);
            if (rank != null) {
                winningCount[rank.getRank()] += 1;
            }
        }
        return winningCount;
    }

    public LottoRank calculateLottoRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        long matchingCount = lottoNumbers.stream().filter(winningNumbers::contains).count();
        LottoRank bonusWin = LottoRank.BONUS;

        if (matchingCount == bonusWin.getMatchingNumbers() && lottoNumbers.contains(bonusNumber)) {
            return bonusWin;
        }

        for (LottoRank rank : LottoRank.values()) {
            if (matchingCount == rank.getMatchingNumbers()) {
                return rank;
            }
        }
        return null;
    }

    public BigDecimal rateOfReturn() {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal totalSpent = BigDecimal.valueOf(user.getCount() * Config.PRICE_UNIT);

        for (LottoRank rank : LottoRank.values()) {
            int count = winningCount[rank.getRank()];
            BigDecimal rankMoney = BigDecimal.valueOf(rank.getMoney());
            sum = sum.add(rankMoney.multiply(BigDecimal.valueOf(count)));
        }

        BigDecimal result = sum.multiply(BigDecimal.valueOf(Config.PERCENT))
                .divide(totalSpent, 1, RoundingMode.HALF_UP);

        return result;
    }


}
