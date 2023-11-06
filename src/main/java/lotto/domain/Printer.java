package lotto.domain;

import java.text.DecimalFormat;

import static lotto.domain.Rank.*;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Statistics.*;

public class Printer {
    private static Printer printer;

    public static Printer getInstance() {
        if (printer == null) {
            return printer = new Printer();
        }
        return printer;
    }

    public void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printStatistics(float rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.getTitle() + " (" + makePlace(FIFTH.getWinnings()) + "원) - " + fifthCount + "개");
        System.out.println(FOURTH.getTitle() + " (" + makePlace(FOURTH.getWinnings()) + "원) - " + fourthCount + "개");
        System.out.println(THIRD.getTitle() + " (" + makePlace(THIRD.getWinnings()) + "원) - " + thirdCount + "개");
        System.out.println(SECOND.getTitle() + " (" + makePlace(SECOND.getWinnings()) + "원) - " + secondCount + "개");
        System.out.println(FIRST.getTitle() + " (" + makePlace(FIRST.getWinnings()) + "원) - " + firstCount + "개");
        System.out.println("총 수익률은 " + rateOfReturn +"%입니다.");
    }

    private static String makePlace(int num) {
        DecimalFormat mkComma = new DecimalFormat("#,###");
        return mkComma.format(num);
    }
}
