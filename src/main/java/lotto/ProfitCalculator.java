package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfitCalculator {

    static int profit;

    static double profitRate;

    // 수익률 계산을 위한 필드 + 초기화
    static int firstPlace = 0; // 6개
    static int secondPlace = 0; // 5개
    static int thirdPlace = 0; // 5개 + 보너스
    static int fourthPlace = 0; // 4개

    static int fifthPlace = 0; // 3개

    static void calculate() {
        int bonusNumber = WinningLotto.bonusNumber;
        for (Lotto lotto: LottoMachine.totalLottoTickets) {
            int numberOfOverlaps = compare(lotto);
            if (numberOfOverlaps == 3) {
                fifthPlace += 1;
            } else if (numberOfOverlaps == 4) {
                fourthPlace += 1;
            } else if (numberOfOverlaps == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) { // depth 수정 필요
                    secondPlace += 1;
                } else {
                    thirdPlace += 1;
                }
            } else if (numberOfOverlaps == 6) {
                firstPlace += 1;
            }
        }
    }

    static int compare(Lotto lotto) {

        List<Integer> winningNumber = WinningLotto.winningLotto.getNumbers();

        // 집합으로 변경
        Set<Integer> winningSet = new HashSet<Integer>(winningNumber);
        Set<Integer> lottoSet = new HashSet<Integer>(lotto.getNumbers());

        // 교집합 구하기
        winningSet.retainAll(lottoSet);

        // 교집합 개수 반환
        return winningSet.size();
    }

    static void calculateProfit() {
        profit = 2000000000*firstPlace + 30000000*secondPlace + 1500000*thirdPlace + 50000*fourthPlace + 5000*fifthPlace;
        profitRate = ((double)profit/LottoMachine.getMoney())*100;
    }

    static void printResult() {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", fifthPlace));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", fourthPlace));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", thirdPlace));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", secondPlace));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", firstPlace));
        System.out.println(String.format("총 수익률은 %s%%입니다.", String.format("%.1f", profitRate)));
    }
}
