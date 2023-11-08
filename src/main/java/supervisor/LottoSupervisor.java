package supervisor;

import static constants.LottoGameConstants.LOTTO_TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lottogenerate.LottoGenerator;
import lottorank.LottoRank;
import print.LottoGameMessagePrinter;

public class LottoSupervisor {

    private final LottoGenerator generate;

    public LottoSupervisor(LottoGenerator lottoGenerator) {
        this.generate = lottoGenerator;
    }

    public void printComparingResult(int[] winningNumbers, int bonusNumber) {
        int[] winCounts = new int[LottoRank.values().length];
        
        List<Lotto> lottoNumbers = new ArrayList<>(generate.getLottoList());

        int totalSpent = lottoTickets(lottoNumbers) * LOTTO_TICKET_PRICE;

        recordRank(winningNumbers, bonusNumber, lottoNumbers, winCounts);

        // 그리고 결과를 당첨 통계 결과를 출력
        LottoGameMessagePrinter.printResult(winCounts,totalSpent);
    }

    private void recordRank(int[] winningNumbers, int bonusNumber, List<Lotto> lottoNumbers, int[] winCounts) {
        for (Lotto lotto : lottoNumbers) {
            int matchCount = 0;
            boolean bonusMatch = false; // 보너스 번호가 일치하는지 확인하기 위한 변수

            // 당첨 번호와 로또 번호를 비교하여 일치하면 machCount++
            matchCount = compareToWinningNum(winningNumbers, lotto, matchCount);
            bonusMatch = lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.decideRank(matchCount, bonusMatch);

            // 당첨 결과를 기록함
            if (rank != null) {
                winCounts[rank.ordinal()]++;
            }
        }
    }

    private int compareToWinningNum(int[] winningNumbers, Lotto lotto, int matchCount) {
        for (int number : winningNumbers) {
            if (lotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int lottoTickets(List<Lotto> lottoNumbers) {
        return lottoNumbers.size();
    }
}

