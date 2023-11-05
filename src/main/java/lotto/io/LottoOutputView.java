package lotto.io;

import static java.util.Collections.sort;

import java.util.Collections;
import java.util.List;

public class LottoOutputView {

    public void printLottoPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public void printWinningStatistics(List<Integer> list) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + list.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + list.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + list.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + list.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + list.get(0) + "개");
    }
}
