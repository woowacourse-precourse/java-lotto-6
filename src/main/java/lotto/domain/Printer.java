package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Printer {
    //상수(static final) 또는 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
    void showLotteryCount(int numberOfLottery) {
        System.out.println("\n"+numberOfLottery+"개를 구매했습니다.");
    }

    void showLotteryNumbers(List<Integer> Lotto) {
        System.out.println(Arrays.toString(Lotto.toArray()));
    }

    void showResult(int matchingThreeNumbers, int matchingFourNumbers, int matchingFiveNumbers, int matchingFiveAndBonusNumbers, int matchingSixNumbers) {
        System.out.println("\n당첨 통계");
        System.out.println("--");
        System.out.println("3개 일치 (5,000원) - "+matchingThreeNumbers+"개");
        System.out.println("4개 일치 (50,000원) - "+matchingFourNumbers+"개");
        System.out.println("5개 일치 (1,500,000원) - "+matchingFiveNumbers+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+matchingFiveAndBonusNumbers+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+matchingSixNumbers+"개");
    }

    void showProfit(double profit) {
        // 수익률을 출력
        String profitFormat = String.format("%,.1f", profit);
        System.out.println("총 수익률은 "+ profitFormat +"%입니다.");
    }
}
