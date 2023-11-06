package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Printer {
    //상수(static final) 또는 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
    void showLotteryCount(int numberOfLottery) {
        System.out.println(numberOfLottery+"개를 구매했습니다.");
    }

    void showLotteryNumbers(List<Integer> Lotto) {
        System.out.println(Arrays.toString(Lotto.toArray()));
    }

    public void showResult() {
        // 당첨 내역을 출력
    }

    public void showProfit() {
        // 수익률을 출력
    }

}
