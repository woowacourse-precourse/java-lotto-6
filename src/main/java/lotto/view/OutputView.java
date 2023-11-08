package lotto.view;

import java.util.List;

public class OutputView {

    public static void printGetPurchasePriceInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGetWinningNumberInput() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void printGetBonusNumberInput() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void printPurchasedLottoPapers(Integer lottoPapers) {
        System.out.println(lottoPapers + "개를 구매했습니다.");
    }

    public static void printPurchasedEachLottoResult(List<Integer> eachLottoNumbers) {
        System.out.print("[");
        for (int i=0;i<eachLottoNumbers.size();i++) {
            System.out.print(eachLottoNumbers.get(i));
            if(i != eachLottoNumbers.size()-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printLottoResults(List<Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+results.get(4)+"개");
        System.out.println("4개 일치 (50,000원) - "+results.get(3)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+results.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+results.get(1)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+results.get(0)+"개");
    }

    public static void printProfit(String profit) {
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }



}
