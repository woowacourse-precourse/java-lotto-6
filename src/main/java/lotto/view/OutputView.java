package lotto.view;

import java.util.List;

public class OutputView {
    public static void askLottoPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showPurchasedLottoQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void showPurchasedLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
