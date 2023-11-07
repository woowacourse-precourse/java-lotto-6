package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;
import lotto.enums.LottoRank;
import lotto.enums.Message;
import lotto.model.User;

public class OutputView {
    User user = new User();
    int totalPrize = 0;

    public void printLottoNumber(List<Lotto> lottoNumbers) {
        System.out.print("\n" + user.getManyLottoTicket());
        Message.PURCHASE_LOTTO.getMessage();
        for (Lotto numbers : lottoNumbers) {
            System.out.print("[");
            System.out.print(joinNumber(numbers.getNumbers()));
            System.out.println("]");
        }
    }

    public String joinNumber(List<Integer> numbers) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int number : numbers) {
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }

    public void printWinningStatistics(HashMap<Integer, Integer> winningCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankCount = getRankCount(lottoRank.getRank(), winningCount);
            printWinningResult(lottoRank, rankCount);
        }
    }

    public int getRankCount(int rank, HashMap<Integer, Integer> winningCount) {
        int rankCount = 0;
        if (winningCount.containsKey(rank)) {
            rankCount = winningCount.get(rank);
        }
        return rankCount;
    }

    public void printWinningResult(LottoRank lottoRank, int rankCount) {
        String prize = formatNumber(lottoRank.getPrize());
        System.out.print(lottoRank.getMatchCount() + "개 일치");
        if (lottoRank.getRank() == 2) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + prize + "원) - " + rankCount + "개");
    }

    public String formatNumber(int number) {
        String prize = String.format("%,d", number);
        return prize;
    }

    public void printTotalProfit(HashMap<Integer, Integer> winningCount) {
        System.out.println("총 수익률은 " + getTotalProfit(winningCount) + "입니다.");
    }

    public String getTotalProfit(HashMap<Integer, Integer> winningCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankCount = getRankCount(lottoRank.getRank(), winningCount);
            addTotalPrize(lottoRank.getPrize(), rankCount);
        }
        return calculateProfit();
    }

    public void addTotalPrize(int prize, int rankCount) {
        totalPrize += prize * rankCount;
    }

    public String calculateProfit() {
        double TotalProfit = ((double) totalPrize / user.getPaymentAmount()) * 100;
        return String.format("%.1f%%", TotalProfit);
    }
}
