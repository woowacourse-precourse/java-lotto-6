package lotto.View;

import lotto.Model.Domain.Lotto;
import java.util.List;

public class OutputUI {
    public static void printRequestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printSuccessfullyPurchased(int price) {
        System.out.printf("\n%d개를 구매했습니다.%n", price);
    }
    public static void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }
}
