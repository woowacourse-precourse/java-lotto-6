package lotto.domain;

import java.util.List;

public class Display {
    private static final String LOTTO_COUNT_INFOMATION = "개를 구매했습니다.";

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int fiveAndBonusCount;
    private int sixCount;

    public void lottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_COUNT_INFOMATION);
        for (Lotto lotto : lottos) {
            lotto.sort();
            System.out.println(lotto);
        }
    }

    public void winningRecords(List<Integer> corrects, List<Integer> bonusCorrects) {
        threeCount = 0;
        fourCount = 0;
        fiveCount = 0;
        fiveAndBonusCount = 0;
        sixCount = 0;
        for (int i = 0; i < corrects.size(); i++) {
            int correct = corrects.get(i);
            if (correct==3) {
                threeCount++;
            }
            if (correct==4) {
                fourCount++;
            }
            if (correct==5) {
                fiveCount++;
            }
            if (correct==5 && bonusCorrects.get(i)==1) {
                fiveCount--;
                fiveAndBonusCount++;
            }
            if (correct==6) {
                sixCount++;
            }
        }
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + threeCount + "개\n" +
                "4개 일치 (50,000원) - " + fourCount + "개\n" +
                "5개 일치 (1,500,000원) - " + fiveCount + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusCount + "개\n" +
                "6개 일치 (2,000,000,000원) - " + sixCount + "개");
    }

    public void profitRate(int purchaseAmount) {
        int profit =
                ((threeCount * 5000) + (fourCount * 50000)
                        + (fiveCount * 1500000) + (fiveAndBonusCount * 30000000)
                        + (sixCount * 2000000000));
        double profitRate = Math.round((profit / purchaseAmount) / 100.0);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
