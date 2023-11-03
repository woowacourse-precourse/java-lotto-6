package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Prize;

public class OutputView {

    public void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printUserLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printPrizeCount(Map<Prize, Integer> map) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize rank : Prize.values()) {
            if (rank != Prize.EMPTY) {
                int count = map.get(rank);
                String matchString = rank.getMatchLottoNumber() + "개 일치";
                if (rank == Prize.SECOND) {
                    matchString += ", 보너스 볼 일치";
                }
                String prizeString = String.format("(%,d원)", rank.getWinningPrize());
                System.out.println(matchString + " " + prizeString + " - " + count + "개");
            }
        }
    }

    public void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}
