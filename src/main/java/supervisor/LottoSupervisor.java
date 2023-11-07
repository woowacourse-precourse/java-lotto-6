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
import print.LottoGameMessagePrinter;

public class LottoSupervisor {

    private LottoGenerator generate;

    public LottoSupervisor(LottoGenerator lottoGenerator) {
        this.generate = lottoGenerator;
    }

    public void compareToWinningNumber(int[] winningNumbers, int bonusNumber) {
        // 당첨 횟수를 기록할 배열을 초기화
        int[] winCounts = new int[LottoRank.values().length];

        List<Lotto> lottoNumbers = generate.getLottoList();

        int lottoPrice = 1000; // 가정으로 로또 한 장의 가격을 1,000원으로 설정
        int totalSpent = lottoNumbers.size() * lottoPrice; // 총 사용 금액 계산

        // 각 로또 별로 당첨 결과를 계산
        for (Lotto lotto : lottoNumbers) {
            int matchCount = 0; // 일치하는 번호의 수를 저장하는 변수.
            boolean bonusMatch = false; // 보너스 번호가 일치하는지 확인

            // 당첨 번호와 로또 번호를 비교하여 일치하면 machCount++
            for (int number : winningNumbers) {
                if (lotto.getNumbers().contains(number)) {
                    matchCount++;
                }
            }

            // 보너스 번호가 일치하는지 확인하고
            bonusMatch = lotto.getNumbers().contains(bonusNumber);

            // 당첨 등수를 결정.
            LottoRank rank = LottoRank.getRank(matchCount, bonusMatch);

            // 당첨 결과를 기록함
            if (rank != null) {
                winCounts[rank.ordinal()]++;
            }
        }
        // 그리고 결과를 당첨 통계 결과를 출력
        LottoGameMessagePrinter.printResult(winCounts,totalSpent);
    }
}

