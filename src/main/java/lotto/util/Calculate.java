package lotto.util;

import lotto.enums.LottoRank;
import lotto.model.Result;
import lotto.model.User;

public class Calculate {
    User user = new User();
    Result result = new Result();

    public void settingLottoTicketCount() {
        user.setLottoTicketCount(user.getPaymentAmount() / 1000);
    }

    public void settingTotalPrize() {
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankCount = getRankCount(lottoRank.getRank());
            result.addTotalPrize(lottoRank.getPrize() * rankCount);
        }
    }

    public int getRankCount(int rank) {
        int rankCount = 0;
        if (result.getWinningCount().containsKey(rank)) {
            rankCount = result.getWinningCount().get(rank);
        }
        return rankCount;
    }

    public void settingTotalProfit() {
        double TotalProfit = ((double) result.getTotalPrize() / user.getPaymentAmount()) * 100;
        result.setTotalProfit(String.format("%.1f%%", TotalProfit));
    }
}
