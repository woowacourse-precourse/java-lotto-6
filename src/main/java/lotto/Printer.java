package lotto;

import java.util.List;
import lotto.dto.LottoNumberDTO;
import lotto.dto.ProfitRateDTO;

public class Printer {
    private static Printer printer;

    private Printer() {}

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void countOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    public void allLotto(List<LottoNumberDTO> lottos) {
        for (LottoNumberDTO lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }

    public void printStatistic(Info info) {
        StringBuilder sb = new StringBuilder();
        int[] statistic = info.getStatistic();
        sb.append("당첨 통계\n").append("---\n")
                .append("3개 일치 (5,000원) - ").append(statistic[Grade.FIFTH_GRADE.getGrade()])
                .append("\n").append("4개 일치 (50,000원) - ")
                .append(statistic[Grade.FIFTH_GRADE.getGrade()]).append("\n")
                .append("5개 일치 (1,500,000원) - ").append(statistic[Grade.FIFTH_GRADE.getGrade()])
                .append("\n").append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(statistic[Grade.FIFTH_GRADE.getGrade()]).append("\n")
                .append("6개 일치 (2,000,000,000원) - ")
                .append(statistic[Grade.FIFTH_GRADE.getGrade()]);
        System.out.println(sb);
    }

    public void profitRate(ProfitRateDTO profitRateDTO) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRateDTO.getProfitRate());
    }
}
