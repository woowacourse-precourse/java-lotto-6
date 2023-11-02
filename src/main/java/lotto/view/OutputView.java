package lotto.view;

import java.util.List;

public class OutputView {
    public static void printLottoNumbers (String numbers) {
        System.out.println(numbers);
    }

    public static void printLottoResult (int sameThree, int sameFour, int sameFive, int sameFiveBonus, int sameAll, int result) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+sameThree+"개");
        System.out.println("4개 일치 (50,000원) - "+sameFour+"개");
        System.out.println("5개 일치 (1,500,000원) - "+sameFive+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+sameFiveBonus+"개");
        System.out.println("6개 일치 (200,000,000원) - "+sameAll+"개");
        System.out.println("총 수익률은 "+result+"입니다.");
    }
}
