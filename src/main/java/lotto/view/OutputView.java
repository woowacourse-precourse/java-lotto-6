package lotto.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void purchasePieces(int pieces) {
        System.out.println("\n" + pieces + "개를 구매했습니다.");
    }

    public void purchaseNum(List<Integer> lottoNum) {
        System.out.println(lottoNum);
    }

    public void errorMessage(String e) {
        System.out.println(e);
    }

    public void statistics(HashMap result) {
        System.out.println("\n당첨통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치 (5,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(1) + "개");
        System.out.println("6개 일치 (5,000원) - " + result.get(0) + "개");
    }
}
