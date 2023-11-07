package supervisor;

import inputdata.LottoBonusNumberInput;
import inputdata.LottoWinningNumberInput;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.Lotto;
import lottogenerate.LottoGenerator;
import lottorank.LottoRank;
import inputdata.LottoTicketInput;

public class LottoSupervisor {

    private List<Lotto> lottoNumbers;
    private LottoGenerator generate;
    public LottoSupervisor(LottoGenerator lottoGenerator) {
        this.generate = lottoGenerator;
        this.lottoNumbers = generate.getLottoList();
    }
    public void compareToWinningNumber(int[] winningNumbers, int bonusNumber) {
        // ?? ??? ??? ??? ???
        int[] winCounts = new int[LottoRank.values().length];

        // ? ?? ?? ?? ??? ??
        for (Lotto lotto : lottoNumbers) {
            int matchCount = 0; // ???? ??? ?? ???? ??.
            boolean bonusMatch = false; // ??? ??? ????? ??

            // ?? ??? ?? ??? ???? ???? machCount++
            for (int number : winningNumbers) {
                if (lotto.getNumbers().contains(number)) {
                    matchCount++;
                }
            }

            // ??? ??? ????? ????
            bonusMatch = lotto.getNumbers().contains(bonusNumber);

            // ?? ??? ??.
            LottoRank rank = LottoRank.getRank(matchCount, bonusMatch);

            // ?? ??? ??
            if (rank != null) {
                winCounts[rank.ordinal()]++;
            }
        }

        // ??? ?????.
        printResult(winCounts);
    }

    private void printResult(int[] winCounts) {
        // ? ???? ?? ??? ??? ??
        for (LottoRank rank : LottoRank.values()) {
            System.out.printf("%d? ?? (%d?) - %d?\n",
                    rank.getMatchCount(), rank.getPrizeMoney(), winCounts[rank.ordinal()]);
        }
    }

}
