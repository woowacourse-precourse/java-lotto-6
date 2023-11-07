package lotto.view;

import java.util.List;

public class OutputView {
    public static void showLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void showPurchaseLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
