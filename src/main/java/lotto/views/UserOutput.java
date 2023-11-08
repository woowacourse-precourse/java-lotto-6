package lotto.views;

import java.util.List;
import lotto.domain.Lotto;

public class UserOutput {
    public static void askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfLottoPurchases(List<Lotto> lottos) {
        int numberOfLottoPurchases = lottos.size();
        System.out.println(numberOfLottoPurchases + "개를 구매했습니다.");
    }
}
