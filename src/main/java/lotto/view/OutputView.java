package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.Domain.LottoRank;

public class OutputView {

    public void printCostMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printMatchNumberMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoResult(EnumMap<LottoRank, Integer> lottoScore) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoScore.forEach(this::printLottoRankResult);

    }

    private void printLottoRankResult(LottoRank lottoRank, int count) {
        if (lottoRank.getBonus() == 1) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", lottoRank.getMatch(),
                    lottoRank.getReward(), count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개%n", lottoRank.getMatch(), lottoRank.getReward(),
                count);
    }

    public void printLottoRatio(EnumMap<LottoRank, Integer> lottoScore, int money) {
        int winning = 0;

        for (LottoRank rank : lottoScore.keySet()) {
            int reward = rank.getReward();
            int count = lottoScore.get(rank);
            winning += (long) reward * count;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) winning * 100 / money);
    }

    public void printError(Exception e) {
        System.out.println(e + "\n");
    }
}
