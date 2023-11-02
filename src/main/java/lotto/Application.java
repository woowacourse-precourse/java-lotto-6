package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.purchase.Purchase;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();

        purchase.makePurchase();

        System.out.println("당첨 번호를 입력해 주세요");
        String chosenNumber = Console.readLine();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + "n" + "개");
        System.out.println("4개 일치 (50,000원) - " + "n" + "개");
        System.out.println("5개 일치 (1,500,000원) - " + "n" + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + "n" + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + "n" + "개");
        System.out.println("총 수익률은 " + "n" + "%입니다.");
    }
}
