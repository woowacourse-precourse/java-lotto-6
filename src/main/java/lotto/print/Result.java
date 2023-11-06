package lotto.print;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;
import lotto.enums.LottoRank;
import lotto.enums.Message;
import lotto.util.User;

public class Result {
    User user = new User();
    int totalPrize = 0;

    public void printLottoNumber(List<Lotto> lottoNumbers) {
        System.out.print(user.getManyLottoTicket());
        Message.PURCHASE_LOTTO.getMessage();
        for (Lotto numbers : lottoNumbers) {
            System.out.print("[");
            System.out.print(joinNumber(numbers.getNumbers()));
            System.out.println("]");
        }
        System.out.println();
    }

    public String joinNumber(List<Integer> numbers) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int number : numbers) {
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }

    public void printWinningStatistics(HashMap<Integer, Integer> winningCount) {
        int rankCount;
        for (int rank = 5; rank > 0; rank--) {
            rankCount = getRankCount(rank, winningCount);
            LottoRank lottoRank = findLottoRank(rank);
            printWinningResult(lottoRank, rankCount);
            addTotalPrize(lottoRank.getPrize(), rankCount);
        }
    }

    public int getRankCount(int rank, HashMap<Integer, Integer> winningCount) {
        int rankCount = 0;
        if (winningCount.containsKey(rank)) {
            rankCount = winningCount.get(rank);
        }
        return rankCount;
    }

    public LottoRank findLottoRank(int rank) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getRank() == rank) {
                return lottoRank;
            }
        }
        return null;
    }

    public void printWinningResult(LottoRank lottoRank, int rankCount) {
        String prize = formatNumber(lottoRank.getPrize());
        System.out.print(lottoRank.getMatchCount() + "개 일치");
        if (lottoRank.getRank() == 2){
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + prize + ") - " + rankCount + "개");
    }

    public String formatNumber(int number) {
        String prize = String.format("%,d", number);
        return prize;
    }

    public void addTotalPrize(int prize, int rankCount){
        totalPrize += prize * rankCount;
    }

    public void printTotalProfit(){
        System.out.println("총 수익률은 " + getTotalProfit() + "%입니다.");
    }

    public String getTotalProfit() {
        return String.format("%.1f", (double) totalPrize / user.getPaymentAmount());
    }
}
